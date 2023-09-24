package dev.kaushar.productservices.services;

import dev.kaushar.productservices.dto.ProductDTO;

public interface ProductService {
    String getAllProducts();

    String getASingleProduct(Long productId);

    String addANewProduct(ProductDTO productDTO);

    String updateAProduct( ProductDTO productDTO,  Long productId);

    String deleteAProduct(Long productId);
}
