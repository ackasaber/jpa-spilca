package example.jpa.lifecycle;

import example.jpa.lifecycle.entities.Product;
import example.jpaunit.JPAUnit;

public class TestPrePersist {
    public static void main(String[] args) {
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                var product = new Product();
                product.setName("Water");
                entityManager.persist(product);
            });
        }
    }
}
