package dev.kaushar.productservices.services;

import dev.kaushar.productservices.dto.AddANewProductDTO;
import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import jakarta.annotation.Nullable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getASingleProduct(Long productId) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}",ProductDTO.class,productId);

        Product product = new Product();
        ProductDTO productDTO = response.getBody();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImageUrl());

        return product;
    }

    @Override
    public Product addANewProduct(ProductDTO product) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<ProductDTO> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                ProductDTO.class
        );

        ProductDTO productDTO1 = response.getBody();
        Product product1 = new Product();
        product.setId(productDTO1.getId());
        product1.setTitle(productDTO1.getTitle());
        product1.setPrice(productDTO1.getPrice());
        product1.setDescription(productDTO1.getDescription());
        product1.setImageUrl(productDTO1.getImageUrl());
        Category category1 = new Category();
        category1.setName(productDTO1.getCategory());
        product1.setCategory(category1);

        return product1;
    }

    @Override
    public Product updateAProduct(ProductDTO productDTO, Long productId) {
        return null;
    }

    @Override
    public Product deleteAProduct(Long productId) {
        return null;
    }
}
