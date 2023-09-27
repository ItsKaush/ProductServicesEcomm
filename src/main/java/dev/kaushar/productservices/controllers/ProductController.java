package dev.kaushar.productservices.controllers;

import dev.kaushar.productservices.dto.AddANewProductDTO;
import dev.kaushar.productservices.dto.GetSingleProductResponseDTO;
import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
    public ResponseEntity<ProductDTO> getASingleProduct(@PathVariable("productId") Long productId){
        ProductDTO productDTO = productToProductDto(productService.getASingleProduct(productId));

        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.add("auth-token","test-token");

        ResponseEntity<ProductDTO> response = new ResponseEntity<>(productDTO, headers, HttpStatus.OK);

        return response;
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


    @PostMapping()
    public ResponseEntity<ProductDTO> addANewProduct(@RequestBody ProductDTO product){
        ProductDTO productDTO = productToProductDto(productService.addANewProduct(product));
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.add("auth-token","test-token");
        ResponseEntity<ProductDTO> response = new ResponseEntity<>(productDTO, HttpStatus.OK);

        return response;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateAProduct(@RequestBody ProductDTO productDTO, @PathVariable("productId") Long productId){
        productService.updateAProduct(productDTO,productId);
        ResponseEntity<Product> response = new ResponseEntity<>(productService.getASingleProduct(productId),HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/{productId}")
    public Product deleteAProduct(@PathVariable("productId") Long productId){
        return null;
    }



}
