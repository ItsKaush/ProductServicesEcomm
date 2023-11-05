package dev.kaushar.productservices.Inheritence.MappedSuperclass;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {
    private String name;
    private String Email;
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long Id;
}
