package dev.kaushar.productservices.dto;

import dev.kaushar.productservices.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDTO {
    private Product product;
}
