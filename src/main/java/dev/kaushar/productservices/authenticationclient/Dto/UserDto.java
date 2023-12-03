package dev.kaushar.productservices.authenticationclient.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private Set<Role> roles;
}
