package dev.kaushar.productservices.Inheritence.JoinTable;

import org.springframework.data.jpa.repository.JpaRepository;


public interface JoinTableUserRepository extends JpaRepository<User,Long> {
    User save (User user);
    User findUserById (Long id);

}
