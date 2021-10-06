package example.jpa.inheritance;

import example.jpa.inheritance.entities.Chocolate;
import example.jpa.inheritance.entities.Product;
import example.jpa.inheritance.entities.Wine;
import example.jpaunit.JPAUnit;

public class TestJoined {
    public static void main(String[] args) {
        var product = new Product();
        product.setName("Sugar");
        
        var choco = new Chocolate();
        choco.setName("Ritter Sport");
        choco.setCalories(575.0);
        
        var wine = new Wine();
        wine.setName("Tsinandali");
        wine.setYear(2018);
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(product);
                entityManager.persist(choco);
                entityManager.persist(wine);
            });
        }
    }
}
