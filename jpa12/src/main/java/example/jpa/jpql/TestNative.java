package example.jpa.jpql;

import example.jpa.jpql.entities.Product;
import example.jpaunit.JPAUnit;

public class TestNative {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                var query = em.createNativeQuery("SELECT * FROM products",
                                           Product.class);
                var products = query.getResultList();
                products.forEach(System.out::println);
            });
        }
    }
}
