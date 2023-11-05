package dev.kaushar.productservices.Inheritence.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TablePerClassUserrepo extends JpaRepository<User, Long> {
    User save (User user);
    User findUserById(Long Id);

}
