package example.jpa.criteria;

import example.jpa.criteria.entities.Product;
import example.jpaunit.JPAUnit;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

public class TestCriteriaAnd {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                CriteriaBuilder builder = entityManager.getCriteriaBuilder();

                // SELECT p FROM Product p WHERE p.price > :min AND p.price < :max;
                // (Note: it should be a BETWEEN in practice.)
                var query = builder.createQuery(Product.class);
                var product = query.from(Product.class);
                var minParam = builder.parameter(BigDecimal.class, "min");
                var maxParam = builder.parameter(BigDecimal.class, "max");
                query.select(product)
                     .where(builder.and(builder.greaterThan(product.get("price"), minParam),
                                        builder.lessThan(product.get("price"), maxParam)));
                var typedQuery = entityManager.createQuery(query);
                typedQuery.setParameter("min", new BigDecimal("1.05"));
                typedQuery.setParameter("max", new BigDecimal("7.00"));
                var products = typedQuery.getResultList();
                products.forEach(System.out::println);
            });
        }
    }
}
