package example.jpa.jpql;

import example.jpaunit.JPAUnit;
import java.math.BigDecimal;

public class TestSum {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                var statement = "SELECT SUM(p.price) FROM Product p";
                var query = em.createQuery(statement, BigDecimal.class);
                BigDecimal total = query.getSingleResult();
                System.out.println("Total price: " + total);
            });
        }
    }
}
