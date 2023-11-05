package dev.kaushar.productservices.Inheritence.JoinTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "J_instructor")
@PrimaryKeyJoinColumn(name = "user_Id")
public class Instructor extends User{
    private int popularity;
}
