package pl.sdacademy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}

