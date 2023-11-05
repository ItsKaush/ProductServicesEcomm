package dev.kaushar.productservices.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
//    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "category_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;
    private double price;
    private String imageUrl;

}
