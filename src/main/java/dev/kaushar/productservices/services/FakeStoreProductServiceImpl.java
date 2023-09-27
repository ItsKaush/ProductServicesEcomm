package dev.kaushar.productservices.services;

import dev.kaushar.productservices.clients.FakeStoreAPIClient.FakeStoreAPIClient;
import dev.kaushar.productservices.clients.FakeStoreAPIClient.FakeStoreProductDto;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreAPIClient.getAllProducts()) {
            products.add(fakeStoreProductDtoToProduct(fakeStoreProductDto));

        }
        return products;
    }

    private Product fakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
            Product product = new Product();

            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            Category category = new Category();
            category.setName(fakeStoreProductDto.getCategory());
            product.setCategory(category);
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImageUrl(fakeStoreProductDto.getImageUrl());

            return product;
    }

    @Override
    public Product getASingleProduct(Long productId) {

        return fakeStoreProductDtoToProduct(fakeStoreAPIClient.getASingleProduct(productId));

    }

    @Override
    public Product addANewProduct(ProductDTO product) {

        return fakeStoreProductDtoToProduct(fakeStoreAPIClient.addANewProduct(product));
    }

    @Override
    public void updateAProduct(ProductDTO productDTO, Long productId) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        restTemplate.put(
                "https://fakestoreapi.com/products/{productId}",
                productDTO,
                productId
        );

    }

    @Override
    public Product deleteAProduct(Long productId) {
        return null;
    }
}
