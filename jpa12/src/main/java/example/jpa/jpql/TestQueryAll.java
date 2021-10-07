package example.jpa.jpql;

import example.jpa.jpql.entities.Product;
import example.jpaunit.JPAUnit;

public class TestQueryAll {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                var query = em.createQuery("SELECT p FROM Product p",
                                           Product.class);
                var products = query.getResultList();
                products.forEach(System.out::println);
            });
        }
    }
}
