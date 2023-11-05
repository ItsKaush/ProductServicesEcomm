package dev.kaushar.productservices.repositories;

public interface Queries {
    String deleteProductQuery = "update product set endTMS = SYSDATE(), last_updatedTMS = SYSDATE()  where id=:id";
}
