package example.jpa.jpql;

import example.jpa.jpql.entities.Product;
import example.jpaunit.JPAUnit;

public class TestNamedQueries {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                var query = em.createNamedQuery("Product.findByName", Product.class);
                query.setParameter("name", "Ale");
                var product = query.getSingleResult();
                System.out.println("Named query returned: " + product);
            });
        }
    }
}
