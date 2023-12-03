package dev.kaushar.productservices.services;

import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import dev.kaushar.productservices.repositories.CategoryRepository;
import dev.kaushar.productservices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier(value = "SelfProductService")
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Product> getAllProducts(String token, Long userId) {
        return productRepository.findByEndTMSNull();
    }

    @Override
    public Optional<Product> getASingleProduct(Long productId) {
        return productRepository.findByIdAndEndTMSNull(productId);
    }

    @Override
    public Product addANewProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setPrice(product.getPrice());
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getTitle());
        newProduct.setImageUrl(product.getImageUrl());
        newProduct.setLastUpdatedTMS(new Date());
        newProduct.setStartTMS(new Date());

        Category category;

        if (categoryRepository.existsByNameAndEndTMSNull(product.getCategory().getName())) {
            // If the category already exists, retrieve it
            category = categoryRepository.findDistinctByNameAndEndTMSNull(product.getCategory().getName());
        } else {
            // If the category does not exist, create a new one
            category = new Category();
            category.setName(product.getCategory().getName());
            category.setStartTMS(new Date());
            category.setLastUpdatedTMS(new Date());
            category = categoryRepository.save(category);
        }

        newProduct.setCategory(category);
        productRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public Optional<Product> updateAProduct(Product product, Long productId) {
        if(productRepository.findByIdAndEndTMSNull(productId).isEmpty()){
            return Optional.empty();
        }

        product.setLastUpdatedTMS(new Date());

        productRepository.save(product);

        return Optional.of(product);
    }

    @Override
    public Optional<Product> deleteAProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findByIdAndEndTMSNull(productId);
        if(productOptional.isEmpty()){
            return Optional.empty();
        }

        productRepository.deleteProductById(productId);

        return productOptional;
    }
}
