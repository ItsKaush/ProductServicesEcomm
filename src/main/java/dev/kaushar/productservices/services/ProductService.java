package dev.kaushar.productservices.services;


import dev.kaushar.productservices.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts(String token, Long userId);

    Optional<Product> getASingleProduct(Long productId) ;

    Product addANewProduct(Product product);

    Optional<Product> updateAProduct( Product product,  Long productId);

    Optional<Product> deleteAProduct(Long productId);
}
