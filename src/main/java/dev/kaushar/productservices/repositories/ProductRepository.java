package dev.kaushar.productservices.repositories;

import dev.kaushar.productservices.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Product save(Product product);

    Optional<Product> findByIdAndEndTMSNull(Long id);


    List<Product> findByEndTMSNull();

    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = Queries.deleteProductQuery, nativeQuery = true)
    void deleteProductById(Long id);

    List<Product> findByEndTMSNullAndCategory_Name(String categoryName);
}
