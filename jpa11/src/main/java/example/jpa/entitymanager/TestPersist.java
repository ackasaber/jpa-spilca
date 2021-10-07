package example.jpa.entitymanager;

import example.jpa.entitymanager.entities.Product;
import example.jpaunit.JPAUnit;

import static java.lang.System.out;

public class TestPersist {
    public static void main(String[] args) {
        var products = new String[] { "Ale", "Beer", "Cider", "Rum", "Wine" };
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                for (int i = 0; i < products.length; ++i) {
                    var product = new Product();
                    product.setId(i + 1);
                    product.setName(products[i]);
                    // Persist saves NEW entities in the database.
                    entityManager.persist(product);
                    out.println("Persisted object " + product);
                }
                
                out.println("End of transaction.");
            });
            
            out.println("End of program.");
        }
    }
}
