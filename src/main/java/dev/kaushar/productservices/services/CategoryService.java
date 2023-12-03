package dev.kaushar.productservices.services;

import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {


    List<Category> getAllCategories();

    Optional<List<Product>> getInCategory(String category);
}
