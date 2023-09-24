package dev.kaushar.productservices.controllers;

import dev.kaushar.productservices.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String getAllCategories(){
        return "Getting All categories";
    }

    @GetMapping("{categoryId}")
    public String getInCategory(@PathVariable("categoryId") Long categoryId){
        return "Getting in Category";
    }
}
