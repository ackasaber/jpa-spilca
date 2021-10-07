package example.jpa.jpql;

import example.jpa.jpql.entities.Product;
import example.jpaunit.JPAUnit;
import java.math.BigDecimal;

public class TestParameterized {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                var statement = "SELECT p FROM Product p " +
                                "WHERE p.price > :price";
                var query = em.createQuery(statement, Product.class);
                query.setParameter("price", new BigDecimal("3"));
                var products = query.getResultList();
                System.out.println("Products that cost more than 3.00, named parameter:");
                products.forEach(System.out::println);
                
                var statement2 = "SELECT p FROM Product p " +
                                 "WHERE p.name LIKE ?1";
                var query2 = em.createQuery(statement2, Product.class);
                query2.setParameter(1, "A%");
                var products2 = query2.getResultList();
                System.out.println("Products with the name starting with A, ordinal parameter:");
                products2.forEach(System.out::println);
            });
        }
    }
}
