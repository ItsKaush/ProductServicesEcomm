package dev.kaushar.productservices.controllers;

import dev.kaushar.productservices.clients.FakeStoreAPIClient.FakeStoreProductDto;
import dev.kaushar.productservices.dto.AddANewProductDTO;
import dev.kaushar.productservices.dto.ErrorResponseDto;
import dev.kaushar.productservices.dto.GetSingleProductResponseDTO;
import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.exceptions.NotFoundException;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService =productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product : products){
            productDTOS.add(productToProductDto(product));
        }
        ResponseEntity<List<ProductDTO>> response = new ResponseEntity<>(productDTOS, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getASingleProduct(@PathVariable("productId") Long productId)  throws NotFoundException {
        Optional<Product> productOptional = productService.getASingleProduct(productId);

        if(productOptional.isEmpty()){
            throw new NotFoundException("No product found with product Id: " + productId);
        }

        ProductDTO productDTO = productToProductDto(productOptional.get());
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.add("auth-token","test-token");

        ResponseEntity<ProductDTO> response = new ResponseEntity<>(productDTO, headers, HttpStatus.OK);

        return response;
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> addANewProduct(@RequestBody ProductDTO product){
        ProductDTO productDTO = productToProductDto(productService.addANewProduct(productDtoToProduct(product)));
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.add("auth-token","test-token");
        ResponseEntity<ProductDTO> response = new ResponseEntity<>(productDTO, HttpStatus.OK);

        return response;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateAProduct(@RequestBody ProductDTO productDTO, @PathVariable("productId") Long productId) throws NotFoundException{

        Optional<Product> productOptional = productService.updateAProduct(productDtoToProduct(productDTO),productId);

        if(productOptional.isEmpty()){
            throw new NotFoundException("No product found with product Id to update: " + productId);
        }

        ProductDTO productDto = productToProductDto(productOptional.get());
        ResponseEntity<ProductDTO> response = new ResponseEntity<>(productDto,HttpStatus.OK);
        return response;
    }


    @DeleteMapping("/{productId}")
    public ProductDTO deleteAProduct(@PathVariable("productId") Long productId) throws NotFoundException{
        Optional<Product> productOptional = productService.deleteAProduct(productId);
        if(productOptional.isEmpty()){
            throw new NotFoundException("Product with id: " + productId + " not found to delete");
        }

        return productToProductDto(productOptional.get());
    }



    private ProductDTO productToProductDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setCategory(product.getCategory().getName());
        return productDTO;
    }

    private Product productDtoToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);

        return product;
    }


}
