package example.jpa.entitymanager;

import example.jpa.entitymanager.entities.Product;
import example.jpaunit.JPAUnit;

public class TestRemove {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                // This won't work:
                // java.lang.IllegalArgumentException:
                // Removing a detached instance example.jpa.entitymanager.entities.Product#2
                
             /* var product1 = new Product();
                product1.setId(2);
                entityManager.remove(product1); */
             
                var product2 = entityManager.find(Product.class, 2);
                System.out.println("Got product #2");
                entityManager.remove(product2);
                System.out.println("Removed.");
            });
        }
    }
}
