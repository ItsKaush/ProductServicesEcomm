package dev.kaushar.productservices.Inheritence.JoinTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoinTableInstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save (Instructor user);


    Optional<Instructor> findInstructorById (Long user_id);
}
