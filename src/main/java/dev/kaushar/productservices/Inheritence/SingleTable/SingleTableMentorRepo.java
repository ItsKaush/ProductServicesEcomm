package dev.kaushar.productservices.Inheritence.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleTableMentorRepo extends JpaRepository<Mentor, Long> {
    Mentor save (Mentor user);
    Mentor findMentorById (Long Id);
}
