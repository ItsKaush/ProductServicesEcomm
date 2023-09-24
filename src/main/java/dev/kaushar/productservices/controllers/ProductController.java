package dev.kaushar.productservices.controllers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService =productService;
    }

    @GetMapping()
    public String getAllProducts(){
        return "Getting all product";
    }

    @GetMapping("/{productId}")
    public String getASingleProduct(@PathVariable("productId") Long productId){
        return "getting single Product";
    }

    @PostMapping()
    public String addANewProduct(@RequestBody ProductDTO productDTO){
        return "Adding a new Product: " + productDTO;
    }

    @PutMapping("/{productId}")
    public String updateAProduct(@RequestBody ProductDTO productDTO, @PathVariable("productId") Long productId){
        return "Updating A Product with productID: "+ productId + "values: " + productDTO;
    }

    @DeleteMapping("/{productId}")
    public String deleteAProduct(@PathVariable("productId") Long productId){
        return "Deleting A Product with product Id: " + productId;
    }



}
