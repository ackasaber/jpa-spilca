package example.jpa.entitymanager;

import example.jpa.entitymanager.entities.Product;
import example.jpaunit.JPAUnit;
import static java.lang.System.out;

public class TestDetach {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                var product = new Product();
                product.setId(2);
                product.setName("Vodka");
                out.println("Created a product");
                entityManager.persist(product);
                out.println("Persisted the product");
                entityManager.detach(product);
                // Now the persist is effectively undone.
                // The difference from refresh is that no SELECT from
                // the database is done to get the up-to-date version of
                // the entity.
                out.println("... and then detached it.");
            });
        }
    }
}
