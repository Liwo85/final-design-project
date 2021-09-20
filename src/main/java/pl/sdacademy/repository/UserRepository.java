package pl.sdacademy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);
}

