package dev.kaushar.productservices.controllers;

import dev.kaushar.productservices.dto.AddANewProductDTO;
import dev.kaushar.productservices.dto.GetSingleProductResponseDTO;
import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService =productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return null;
    }

    @GetMapping("/{productId}")
    public GetSingleProductResponseDTO getASingleProduct(@PathVariable("productId") Long productId){
        GetSingleProductResponseDTO responseDto = new GetSingleProductResponseDTO();
        responseDto.setProduct(productService.getASingleProduct(productId));
        return responseDto;
    }

    @PostMapping()
    public ResponseEntity<Product> addANewProduct(@RequestBody ProductDTO product){
        ResponseEntity<Product> response = new ResponseEntity<>(productService.addANewProduct(product), HttpStatus.OK);
        return response;
    }

    @PutMapping("/{productId}")
    public Product updateAProduct(@RequestBody ProductDTO productDTO, @PathVariable("productId") Long productId){
        return null;
    }

    @DeleteMapping("/{productId}")
    public Product deleteAProduct(@PathVariable("productId") Long productId){
        return null;
    }



}
