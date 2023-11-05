package dev.kaushar.productservices.Inheritence.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TablePerClassStudentRepo extends JpaRepository<Student, Long> {
    Student save (Student user);
    Student findStudentById(Long Id);

}
