package example.jpa.lifecycle;

import example.jpa.lifecycle.entities.Product;
import example.jpaunit.JPAUnit;

public class TestPreUpdate {
       public static void main(String[] args) {
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                var product = entityManager.find(Product.class, 1);
                product.setName("Wine");
            });
        }
    }
}
