package example.jpa.inheritance;

import example.jpa.inheritance.entities.Employee;
import example.jpa.inheritance.entities.Manager;
import example.jpaunit.JPAUnit;

public class TestTablePerEntity {
    public static void main(String[] args) {
        var employee = new Employee();
        employee.setName("Вася Пупкин");
        var manager = new Manager();
        manager.setName("Кощей Бессмертный");
        manager.setResponsibility("Сеять плохое, злое и вечное.");
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(employee);
                entityManager.persist(manager);
            });
        }
    }
}
