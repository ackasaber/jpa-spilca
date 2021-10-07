package example.jpa.entitymanager;

import example.jpa.entitymanager.entities.Product;
import example.jpaunit.JPAUnit;
import static java.lang.System.out;

public class TestRefresh {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                var product = entityManager.find(Product.class, 3);
                out.println("Found product " + product);
                product.setName("Vodka");
                out.println("Changed product to " + product);
                entityManager.refresh(product);
                out.println("Refreshed the product: " + product);
            });
        }
    }
}
