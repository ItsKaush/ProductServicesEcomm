package dev.kaushar.productservices.services;

import dev.kaushar.productservices.clients.FakeStoreAPIClient.FakeStoreAPIClient;
import dev.kaushar.productservices.clients.FakeStoreAPIClient.FakeStoreProductDto;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier (value = "FakeStoreService")
public class FakeStoreCategoryServiceImpl implements CategoryService{

    private FakeStoreAPIClient fakeStoreAPIClient;
    public FakeStoreCategoryServiceImpl(FakeStoreAPIClient fakeStoreAPIClient){
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }
    @Override
    public List<Category> getAllCategories() {
        List<String> fakeStoreCategories = fakeStoreAPIClient.getAllCategory();

        List<Category> categories = new ArrayList<>();
        for(String fakeStoreCategoryDto : fakeStoreCategories){
            Category category = new Category();
            category.setName(fakeStoreCategoryDto);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Optional<List<Product>> getInCategory(String  category) {
        Optional<List<FakeStoreProductDto>> fakeStoreProductDtos = fakeStoreAPIClient.getInCategory(category);

        if(fakeStoreProductDtos.isEmpty()){
            return Optional.empty();
        }

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos.get()){
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setImageUrl(fakeStoreProductDto.getImage());
            Category category1 = new Category();
            category1.setName(fakeStoreProductDto.getCategory());
            product.setCategory(category1);

            products.add(product);
        }

        return Optional.of(products);
    }
}
