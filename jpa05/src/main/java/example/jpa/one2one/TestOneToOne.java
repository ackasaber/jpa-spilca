package example.jpa.one2one;

import example.jpa.one2one.entities.NutritionInfo;
import example.jpa.one2one.entities.Product;
import example.jpa.one2one.entities.ProductWeight;
import example.jpaunit.JPAUnit;
import java.math.BigDecimal;

public class TestOneToOne {
    public static void main(String[] args) {
        var nutrition = new NutritionInfo();
        nutrition.setCalories(65.0);
        nutrition.setFat(0.0);
        nutrition.setCarbohydrates(17.0);
        
        var weight = new ProductWeight();
        weight.setNetto(0.125);
        weight.setBrutto(0.200);

        var product = new Product();
        product.setName("Apple Busket");
        product.setPrice(new BigDecimal("1.00"));
        product.setNutrition(nutrition);
        
        // Important: JPA requires that for bi-directional relationships
        // fields on both sides are set and match.
        product.setWeight(weight);
        weight.setProduct(product);
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                // Cascading on weight is enabled, therefore the weight
                // doesn't have to be persisted explicitely.
                entityManager.persist(product);
                entityManager.persist(nutrition);
            });
        }
    }
}
