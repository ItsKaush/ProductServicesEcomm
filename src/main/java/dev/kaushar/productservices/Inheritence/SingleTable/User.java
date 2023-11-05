package dev.kaushar.productservices.Inheritence.SingleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User {
    private String name;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
