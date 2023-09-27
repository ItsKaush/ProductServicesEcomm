package dev.kaushar.productservices.clients.FakeStoreAPIClient;


import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<FakeStoreProductDto> fakeStoreProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : response.getBody()) {
            fakeStoreProductDtos.add(fakeStoreProductDto);
        }

        return fakeStoreProductDtos;
    }

    public FakeStoreProductDto getASingleProduct(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}",
                                                                                    FakeStoreProductDto.class, productId).getBody();

        return fakeStoreProductDto;
    }

    public FakeStoreProductDto addANewProduct(ProductDTO product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductDto.class
        );
        return response.getBody();
    }


}
