package dev.kaushar.productservices.clients.FakeStoreAPIClient;


import dev.kaushar.productservices.dto.ProductDTO;
import dev.kaushar.productservices.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<FakeStoreProductDto> fakeStoreProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : response.getBody()) {
            fakeStoreProductDtos.add(fakeStoreProductDto);
        }

        return fakeStoreProductDtos;
    }

    public Optional<FakeStoreProductDto> getASingleProduct(Long productId){

        RestTemplate restTemplate = restTemplateBuilder.build();
        Optional<FakeStoreProductDto> fakeStoreProductDto = Optional.ofNullable(restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}",
                                                                                    FakeStoreProductDto.class, productId).getBody());
        if(fakeStoreProductDto.isEmpty()){
            return Optional.empty();
        }
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto addANewProduct(FakeStoreProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductDto.class
                ).getBody();

        return fakeStoreProductDto;

    }

    public Optional<FakeStoreProductDto> updateAProduct(FakeStoreProductDto product, Long productId){

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = requestForEntity(
                "https://fakestoreapi.com/products/{productId}",
                HttpMethod.PATCH,
                product,
                FakeStoreProductDto.class,
                productId
        );

        if(fakeStoreProductDto==null){
            return Optional.empty();
        }
        return Optional.of(fakeStoreProductDto.getBody());
    }

    public Optional<FakeStoreProductDto> deleteAProduct(Long productId){

        Optional<FakeStoreProductDto> fakeStoreProductDtoOptional = Optional.ofNullable(deleteForEntity("https://fakestoreapi.com/products/{id}",
                            HttpMethod.DELETE,
                            null,
                            FakeStoreProductDto.class,
                            productId).getBody());

        if(fakeStoreProductDtoOptional.isEmpty()){
            return Optional.empty();
        }

        return fakeStoreProductDtoOptional;
    }

    public List<String> getAllCategory(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String[]> categories = restTemplate.getForEntity("https://fakestoreapi.com/products/categories",
                String[].class);

        List<String> responseCategory = new ArrayList<>();
        for(String category : categories.getBody()){
            responseCategory.add(category);
        }
        return responseCategory;
    }

    public Optional<List<FakeStoreProductDto>> getInCategory(String category){
        RestTemplate restTemplate = restTemplateBuilder.build();
        Optional<ResponseEntity<FakeStoreProductDto[]>> fakeStoreProductDtoResponse =
                                    Optional.of(restTemplate.getForEntity("https://fakestoreapi.com/products/category/{category}",
                                    FakeStoreProductDto[].class,
                                            category));

        if(fakeStoreProductDtoResponse.isEmpty()){
            return Optional.empty();
        }
        List<FakeStoreProductDto> fakeStoreProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoResponse.get().getBody()){
            fakeStoreProductDtos.add(fakeStoreProductDto);
        }

        return Optional.of(fakeStoreProductDtos);
    }

    private  <T> ResponseEntity<T> requestForEntity(String url,HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
//        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private  <T> ResponseEntity<T> deleteForEntity(String url,HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
//        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


}
