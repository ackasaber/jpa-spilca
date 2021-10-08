package example.jpa.lifecycle;

import example.jpa.lifecycle.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TestCaching {

    public static void main(String[] args) {
        var factory = Persistence.createEntityManagerFactory("postgres-unit");

        try {
            EntityManager entityManager = null;

            try {
                entityManager = factory.createEntityManager();
                var product = entityManager.find(Product.class, 2);
                
                var cache = factory.getCache();
                System.out.println("The product is in the cache? " +
                                   cache.contains(Product.class, 2));

            } finally {
                if (entityManager != null) {
                    entityManager.close();
                }
            }
        } finally {
            factory.close();
        }
    }
}
