package dev.kaushar.productservices.services;

import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.repositories.CategoryRepository;
import dev.kaushar.productservices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier(value = "SelfCategoryService")
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findByEndTMSNull();
    }

    @Override
    public Optional<List<Product>> getInCategory(String category) {
        List<Product> products = productRepository.findByEndTMSNullAndCategory_Name(category);
        return products.isEmpty() ? Optional.empty() : Optional.of(products);
    }
}
