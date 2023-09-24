package dev.kaushar.productservices.dto;

import dev.kaushar.productservices.models.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private String title;
    private String description;
    private String category;
    private double price;
    private String imageUrl;
}
