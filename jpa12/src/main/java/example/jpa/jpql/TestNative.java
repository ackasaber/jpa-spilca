package example.jpa.jpql;

import java.util.List;

import example.jpa.jpql.entities.Product;
import example.jpaunit.JPAUnit;
import jakarta.persistence.Query;

public class TestNative {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                Query query = em.createNativeQuery("SELECT * FROM products",
                                           Product.class);
                List<?> products = query.getResultList();
                products.forEach(System.out::println);
            });
        }
    }
}
