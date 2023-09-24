package dev.kaushar.productservices.services;

import dev.kaushar.productservices.dto.AddANewProductDTO;
import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getASingleProduct(Long productId);

    Product addANewProduct(ProductDTO product);

    Product updateAProduct( ProductDTO productDTO,  Long productId);

    Product deleteAProduct(Long productId);
}
