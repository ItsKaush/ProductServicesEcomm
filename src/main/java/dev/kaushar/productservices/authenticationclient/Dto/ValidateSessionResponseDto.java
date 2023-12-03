package dev.kaushar.productservices.authenticationclient.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateSessionResponseDto {
    private UserDto userDto;
    private SessionStatus sessionStatus;
}
