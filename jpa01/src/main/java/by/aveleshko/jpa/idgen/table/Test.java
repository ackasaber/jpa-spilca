package by.aveleshko.jpa.idgen.table;

import by.aveleshko.jpaunit.JPAUnit;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        var product1 = new Product();
        product1.setName("Wine");
        product1.setPrice(new BigDecimal("15.70"));
        product1.setExpirationDate(LocalDate.now());
        
        var product2 = new Product();
        product2.setName("Beer");
        product2.setPrice(new BigDecimal("5.00"));
        product2.setExpirationDate(LocalDate.of(2021, Month.DECEMBER, 10));
        
        var product3 = new Product();
        product3.setName("Champagne");
        product3.setPrice(new BigDecimal("15.99"));
        product3.setExpirationDate(LocalDate.of(2022, Month.JANUARY, 01));
        
        var products = new Product[]{ product1, product2, product3 };
        
        try (var unit = new JPAUnit("test-unit")) {
            unit.runTransaction(entityManager -> {
                Arrays.stream(products).forEach(entityManager::persist);
            });
        }
    }
}
