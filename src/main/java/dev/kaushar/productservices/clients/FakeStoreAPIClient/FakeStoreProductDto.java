package dev.kaushar.productservices.clients.FakeStoreAPIClient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long Id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String imageUrl;
}
