package dev.kaushar.productservices.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public class BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startTMS;
    private Date endTMS;
    private Date lastUpdatedTMS;
}
