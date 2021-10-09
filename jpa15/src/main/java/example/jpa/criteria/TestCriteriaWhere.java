package example.jpa.criteria;

import example.jpa.criteria.entities.Product;
import example.jpaunit.JPAUnit;
import jakarta.persistence.criteria.CriteriaBuilder;

public class TestCriteriaWhere {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                CriteriaBuilder builder = entityManager.getCriteriaBuilder();

                // SELECT p FROM Product p WHERE p.price > 5;
                var query = builder.createQuery(Product.class);
                var product = query.from(Product.class);
                query.select(product)
                     .where(builder.greaterThan(product.get("price"), 5));
                var typedQuery = entityManager.createQuery(query);
                var products = typedQuery.getResultList();
                products.forEach(System.out::println);
            });
        }
    }
}
