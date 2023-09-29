package dev.kaushar.productservices.services;

import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {


    public List<Category> getAllCategories();

    public Optional<List<Product>> getInCategory(String category);
}
