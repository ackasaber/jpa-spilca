package example.jpa.criteria;

import example.jpa.criteria.entities.Product;
import example.jpaunit.JPAUnit;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TestCriteriaAll {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                CriteriaBuilder builder = entityManager.getCriteriaBuilder();

                // SELECT p FROM Product p;
                CriteriaQuery<Product> query = builder.createQuery(Product.class);
                query.select(query.from(Product.class));
                TypedQuery<Product> typedQuery = entityManager.createQuery(query);
                List<Product> products = typedQuery.getResultList();
                System.out.println("All products:");
                products.forEach(System.out::println);
            });
        }
    }
}
