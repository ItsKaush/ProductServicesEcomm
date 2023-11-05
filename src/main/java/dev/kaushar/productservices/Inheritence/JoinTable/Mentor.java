package dev.kaushar.productservices.Inheritence.JoinTable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Join;

@Getter
@Setter
@Entity(name = "j_mentor")
@PrimaryKeyJoinColumn(name = "user_Id")
public class Mentor extends User{
    private int mentees;
    private int session;
}
