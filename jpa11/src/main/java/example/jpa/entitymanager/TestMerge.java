package example.jpa.entitymanager;

import example.jpa.entitymanager.entities.Product;
import example.jpaunit.JPAUnit;
import static java.lang.System.out;

public class TestMerge {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                var product = new Product();
                product.setId(3);
                product.setName("Schnapps");
                out.println("Created a product");
                // The same as persist, but we know that the entity is already there.
                var proxy = entityManager.merge(product);
                out.println("Merged the product.");
                out.println("The updated object: " + product);
                out.println("The proxy: " + proxy);
                out.println("The updated object in the contex: " +
                        entityManager.contains(product));
                out.println("The proxy in the context: " +
                        entityManager.contains(proxy));
            });
        }
    }
}
