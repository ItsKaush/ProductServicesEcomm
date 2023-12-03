package dev.kaushar.productservices.services;

import dev.kaushar.productservices.clients.FakeStoreAPIClient.FakeStoreAPIClient;
import dev.kaushar.productservices.clients.FakeStoreAPIClient.FakeStoreProductDto;
import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }
    @Override
    public List<Product> getAllProducts(String token, Long userId) {
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreAPIClient.getAllProducts()) {
            products.add(fakeStoreProductDtoToProduct(fakeStoreProductDto));

        }
        return products;
    }

    @Override
    public Optional<Product> getASingleProduct(Long productId) {
        Optional<FakeStoreProductDto> fakeStoreProductDtoOptional = fakeStoreAPIClient.getASingleProduct(productId);
        if(fakeStoreProductDtoOptional.isEmpty()){
            return Optional.empty();
        }
        Optional<Product> productOptional = Optional.of(fakeStoreProductDtoToProduct(fakeStoreProductDtoOptional.get()));

        return productOptional;

    }

    @Override
    public Product addANewProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = productToFakeStoreProductDto(product);

        return fakeStoreProductDtoToProduct(fakeStoreAPIClient.addANewProduct(fakeStoreProductDto));
    }

    @Override
    public Optional<Product> updateAProduct(Product product, Long productId) {
        FakeStoreProductDto fakeStoreProductDto = productToFakeStoreProductDto(product);

        Optional<FakeStoreProductDto> fakeStoreProductDtoOptional = fakeStoreAPIClient.updateAProduct(fakeStoreProductDto, productId);

        if(fakeStoreProductDtoOptional.isEmpty()){
            return Optional.empty();
        }

        Optional<Product> productOptional = Optional.of(fakeStoreProductDtoToProduct(fakeStoreProductDtoOptional.get()));

       return productOptional;

    }

    @Override
    public Optional<Product> deleteAProduct(Long productId) {
        Optional<FakeStoreProductDto> fakeStoreProductDtoOptional = fakeStoreAPIClient.deleteAProduct(productId);
        if(fakeStoreProductDtoOptional.isEmpty()){
            return Optional.empty();
        }

        Optional<Product> productOptional = Optional.of(fakeStoreProductDtoToProduct(fakeStoreProductDtoOptional.get()));

        return productOptional;
    }


    private Product fakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        return product;
    }

    private FakeStoreProductDto productToFakeStoreProductDto(Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());

        return fakeStoreProductDto;
    }
}
