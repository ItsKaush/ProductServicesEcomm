package dev.kaushar.productservices.Inheritence.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleTableStudentRepo extends JpaRepository<Student, Long> {
    Student save (Student user);
    Student findStudentById (Long Id);
}
