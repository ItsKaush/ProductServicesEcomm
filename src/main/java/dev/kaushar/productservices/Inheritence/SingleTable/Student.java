package dev.kaushar.productservices.Inheritence.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_student")
@DiscriminatorValue("3")
public class Student extends User{
    private double psp;
    private double attendence;
}
