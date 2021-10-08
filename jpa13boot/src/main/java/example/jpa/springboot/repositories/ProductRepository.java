package example.jpa.springboot.repositories;

import example.jpa.springboot.entitites.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Product repository.
 * 
 * Demonstrates the usage of Spring Data JPA. Spring will generate the necessary
 * repository implementation based on method names or the custom JPQL queries
 * defined via {@code @Query} annotation.
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
    // :name is substituted with the correspondingly named method argument
    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    List<Product> findProductsByName(String name);
}
