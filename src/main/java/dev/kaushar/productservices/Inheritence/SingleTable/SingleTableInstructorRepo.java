package dev.kaushar.productservices.Inheritence.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleTableInstructorRepo extends JpaRepository<Instructor, Long> {
    Instructor save (Instructor user);
    Instructor findInstructorById (Long Id);
}
