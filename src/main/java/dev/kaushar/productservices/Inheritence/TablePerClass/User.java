package dev.kaushar.productservices.Inheritence.TablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    private String name;
    private String Email;
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long Id;
}
