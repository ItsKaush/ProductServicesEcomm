package dev.kaushar.productservices.Inheritence.SingleTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleTableUserRepo extends JpaRepository<User, Long> {
    User save (User user);
    User findUserById (Long Id);
}
