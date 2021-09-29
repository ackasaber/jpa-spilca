package example.jpa.types;

import example.jpa.types.entities.Price;
import example.jpa.types.entities.enums.Currency;
import example.jpa.types.entities.enums.OfferType;
import example.jpaunit.JPAUnit;
import java.math.BigDecimal;
import java.util.Arrays;

public class TestEnums {

    public static void main(String[] args) {
        var price1 = new Price();
        price1.setAmount(new BigDecimal("5.00"));
        price1.setCurrency(Currency.USD);
        price1.setOfferType(OfferType.FULL_PRICE);
        
        var price2 = new Price();
        price2.setAmount(new BigDecimal("1.50"));
        price2.setCurrency(Currency.EUR);
        price2.setOfferType(OfferType.DISCOUNTED);
        
        var prices = new Price[]{ price1, price2 };

        try (var jpaUnit = new JPAUnit("postgres-unit")) {
            jpaUnit.runTransaction(entityManager -> {
                Arrays.stream(prices).forEach(entityManager::persist);
            });
        }
    }
}
