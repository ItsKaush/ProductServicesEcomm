package dev.kaushar.productservices.controllers;

import dev.kaushar.productservices.authenticationclient.AuthenticationClient;
import dev.kaushar.productservices.authenticationclient.Dto.Role;
import dev.kaushar.productservices.authenticationclient.Dto.SessionStatus;
import dev.kaushar.productservices.authenticationclient.Dto.ValidateSessionResponseDto;
import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.exceptions.NotFoundException;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Qualifier("SelfProductService")
    private ProductService productService;


    private final AuthenticationClient authenticationClient;
    public ProductController(@Qualifier("SelfProductService") ProductService productService, AuthenticationClient authenticationClient){
        this.productService = productService;
        this.authenticationClient = authenticationClient;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts(@Nullable @RequestHeader("AUTH_TOKEN") String token, @Nullable @RequestHeader("USER_ID") Long userId){
//        if(token == null || userId == null){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//        //check the token returned by auth client, if it is active then go ahead
//        ValidateSessionResponseDto responseDto = authenticationClient.validate(token,userId);
//        if(responseDto.getSessionStatus().equals(SessionStatus.INVALID)){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//        //It session active, then check if has a specific role then only call the product service
//        Set<Role> userRoles = responseDto.getUserDto().getRoles();
//        boolean isAdmin = false;
//        for(Role role : userRoles){
//            if (role.getRole().equals("ADMIN")) {
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if(!isAdmin){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }

        List<Product> products = productService.getAllProducts(token, userId);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product : products){
            productDTOS.add(productToProductDto(product));
        }
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
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
        Product newProduct = productDtoToProduct(product);
        Product addedProduct = productService.addANewProduct(newProduct);
        ProductDTO productDTO = productToProductDto(addedProduct);
//        ProductDTO productDTO = productToProductDto(productService.addANewProduct(productDtoToProduct(product)));
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.add("auth-token","test-token");

        return new ResponseEntity<>(productDTO, HttpStatus.OK);
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
