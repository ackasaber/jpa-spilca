package by.aveleshko.jpa01;

import by.aveleshko.jpa01.entities.Product;
import by.aveleshko.jpa01.jpaunit.JPAUnit;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        try (var unit = new JPAUnit("testUnit")) {
            unit.runTransaction(entityManager -> {
                var product = new Product();
                product.setName("Wine");
                product.setPrice(new BigDecimal("15.70"));
                product.setExpirationDate(LocalDate.now());
                entityManager.persist(product);
            });
        }
    }
}
