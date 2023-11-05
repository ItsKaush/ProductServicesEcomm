package dev.kaushar.productservices.Inheritence.MappedSuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "map_mentor")
public class Mentor extends User{
    private int mentees;
    private int session;
}
