package dev.kaushar.productservices.Inheritence.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TablePerClassInstructorRepo extends JpaRepository<Instructor, Long> {
    Instructor save (Instructor user);
    Instructor findInstructorById(Long Id);

}
