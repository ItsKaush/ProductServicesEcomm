package dev.kaushar.productservices.Inheritence.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TablePerClassMentorRepo extends JpaRepository<Mentor, Long> {
    Mentor save (Mentor user);
    Mentor findMentorById(Long Id);

}
