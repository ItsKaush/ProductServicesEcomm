package dev.kaushar.productservices.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {


    public String getAllCategories();

    public String getInCategory(Long categoryId);
}
