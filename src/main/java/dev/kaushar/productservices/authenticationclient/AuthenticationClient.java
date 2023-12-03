package dev.kaushar.productservices.authenticationclient;

import dev.kaushar.productservices.authenticationclient.Dto.ValidateSessionResponseDto;
import dev.kaushar.productservices.authenticationclient.Dto.ValidateTokenRequestDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationClient {
    private final RestTemplateBuilder restTemplateBuilder;

    public AuthenticationClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ValidateSessionResponseDto validate(String token, Long userId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ValidateTokenRequestDto requestDto = new ValidateTokenRequestDto();
        requestDto.setToken(token);
        requestDto.setUserId(userId);
        ResponseEntity<ValidateSessionResponseDto> response=
                                        restTemplate.postForEntity(
                                                "http://localhost:8180/auth/validate"
                                                ,requestDto
                                                ,ValidateSessionResponseDto.class
                                        );

        return response.getBody();

    }
}
