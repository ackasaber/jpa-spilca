package example.jpa.entitymanager;

import example.jpa.entitymanager.entities.Product;
import example.jpaunit.JPAUnit;
import static java.lang.System.out;

public class TestFind {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                out.println("Requesting product #3");
                var product1 = entityManager.find(Product.class, 3);
                out.println("Find completed.");
                System.out.println(product1);
                
                out.println("Getting the reference to #3");
                var product2 = entityManager.getReference(Product.class, 3);
                System.out.println("Reference is taken.");
                out.println(product2);
                
                out.println("Getting the reference to #1");
                var product3 = entityManager.getReference(Product.class, 1);
                out.println("Reference is taken.");
                out.println(product3);
                
                var product4 = new Product();
                product4.setId(3);
                product4.setName("Water");
                out.println("Created a product.");
                
                out.println("Product #3 in the context: " + entityManager.contains(product1));
                out.println("Reference to #3 in the context: " + entityManager.contains(product2));
                out.println("Reference to #1 in the context: " + entityManager.contains(product3));
                out.println("The created product in the context: " + entityManager.contains(product4));
            });
        }
    }
}
