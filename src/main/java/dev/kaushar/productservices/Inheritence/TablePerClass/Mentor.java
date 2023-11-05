package dev.kaushar.productservices.Inheritence.TablePerClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User{
    private int mentees;
    private int session;
}
