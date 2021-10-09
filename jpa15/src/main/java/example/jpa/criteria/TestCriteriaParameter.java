package example.jpa.criteria;

import example.jpa.criteria.entities.Product;
import example.jpaunit.JPAUnit;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.ParameterExpression;
import java.math.BigDecimal;

public class TestCriteriaParameter {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                CriteriaBuilder builder = entityManager.getCriteriaBuilder();

                // SELECT p FROM Product p WHERE p.price > :price;
                var query = builder.createQuery(Product.class);
                var product = query.from(Product.class);
                ParameterExpression<BigDecimal> param = builder.parameter(BigDecimal.class, "price");
                query.select(product)
                     .where(builder.greaterThan(product.get("price"), param));
                var typedQuery = entityManager.createQuery(query);
                typedQuery.setParameter("price", new BigDecimal(5));
                var products = typedQuery.getResultList();
                products.forEach(System.out::println);
            });
        }
    }
}
