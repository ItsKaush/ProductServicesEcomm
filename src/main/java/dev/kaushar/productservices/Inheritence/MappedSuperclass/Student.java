package dev.kaushar.productservices.Inheritence.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "map_student")
public class Student extends User{
    private double psp;
    private double attendence;
}
