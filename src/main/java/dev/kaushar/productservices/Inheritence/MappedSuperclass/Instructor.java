package dev.kaushar.productservices.Inheritence.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "map_instructor")
public class Instructor extends User{
    private int popularity;
}
