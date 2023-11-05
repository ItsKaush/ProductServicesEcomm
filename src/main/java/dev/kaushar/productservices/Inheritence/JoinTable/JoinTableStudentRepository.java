package dev.kaushar.productservices.Inheritence.JoinTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinTableStudentRepository extends JpaRepository<Student,Long> {
    Student save (Student user);

    Instructor findStudentById (Long id);

}
