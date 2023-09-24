package dev.kaushar.productservices.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class BaseModel{
    private Long id;
    private Date startTMS;
    private Date endTMS;
    private Date lastUpdatedTMS;
}
