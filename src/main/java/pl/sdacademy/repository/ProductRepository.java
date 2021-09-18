package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
