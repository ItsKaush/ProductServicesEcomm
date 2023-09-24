package dev.kaushar.productservices.services;

import dev.kaushar.productservices.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductServiceImpl implements ProductService {
    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public String getASingleProduct(Long productId) {
        return null;
    }

    @Override
    public String addANewProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public String updateAProduct(ProductDTO productDTO, Long productId) {
        return null;
    }

    @Override
    public String deleteAProduct(Long productId) {
        return null;
    }
}
