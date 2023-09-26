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
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
        return response;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getASingleProduct(@PathVariable("productId") Long productId){
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.add("auth-token","test-token");

        ResponseEntity<Product> response = new ResponseEntity<>(productService.getASingleProduct(productId), headers, HttpStatus.OK);

        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> addANewProduct(@RequestBody ProductDTO product){
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<>();
        headers.add("auth-token","test-token");
        ResponseEntity<Product> response = new ResponseEntity<>(productService.addANewProduct(product), HttpStatus.OK);
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
