package dev.kaushar.productservices.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddANewProductDTO {
    private String title;
    private String description;
    private String category;
    private double price;
    private String imageUrl;
}
