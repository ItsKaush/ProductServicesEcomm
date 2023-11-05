package dev.kaushar.productservices.controllers;

import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.exceptions.NotFoundException;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(@Qualifier("SelfCategoryService") CategoryService  categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){
        List<Category> categoryServicecategories = categoryService.getAllCategories();

        List<String> categories = new ArrayList<>();
        for(Category category : categoryServicecategories){
            categories.add(category.getName());
        }
        return categories;
    }

    @GetMapping("/category/{category}")
    public List<ProductDTO> getInCategory(@PathVariable("category") String category) throws NotFoundException{
        Optional<List<Product>> products = categoryService.getInCategory(category);

        if(products.isEmpty()){
            throw new NotFoundException("There are no products in Category: " + category + "or no category exists with input name.");
        }

        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product: products.get()){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setCategory(product.getCategory().getName());
            productDTO.setTitle(product.getTitle());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());
            productDTO.setImageUrl(product.getImageUrl());

            productDTOS.add(productDTO);
        }

        return productDTOS;
    }
}
