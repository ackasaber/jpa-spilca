package example.jpa.inheritance;

import example.jpa.inheritance.entities.Bicycle;
import example.jpa.inheritance.entities.Car;
import example.jpaunit.JPAUnit;

public class TestMappedSuperclass {
    public static void main(String[] args) {
        var car = new Car();
        car.setColor("Black");
        car.setHorsePower(140);
        
        var bike = new Bicycle();
        bike.setColor("Silver");
        bike.setModel("Juggernaut");
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(car);
                entityManager.persist(bike);
            });
        }
    }
}
