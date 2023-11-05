package dev.kaushar.productservices.repositories;

import dev.kaushar.productservices.models.Category;
import dev.kaushar.productservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category category);

    Optional<Category> findByIdAndEndTMSNull(Long id);

    Category findDistinctByNameAndEndTMSNull(String name);

    List<Category> findByEndTMSNull();

    Boolean existsByNameAndEndTMSNull(String name);

}
