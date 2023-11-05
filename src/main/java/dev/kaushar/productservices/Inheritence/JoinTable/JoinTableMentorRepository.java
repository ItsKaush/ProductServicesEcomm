package dev.kaushar.productservices.Inheritence.JoinTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinTableMentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save (Mentor user);
    Instructor findMentorById (Long id);

}
