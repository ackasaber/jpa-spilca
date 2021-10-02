package example.jpa.assocoverride;

import example.jpa.assocoverride.entities.Department;
import example.jpa.assocoverride.entities.Employee;
import example.jpa.assocoverride.entities.Manager;
import example.jpaunit.JPAUnit;

public class TestAssocOverride {
    public static void main(String[] args) {
        var employee1 = new Employee("John Smith", "103-45-40");
        var employee2 = new Employee("Mary Johnson", "340-12-09");
        var employee3 = new Employee("Bethany Wills", "671-14-06");
        
        var salesDirector = new Manager(employee1, "4-003");
        var salesAccountant = new Manager(employee2, "4-004");
        var rdDirector = new Manager(employee3, "4-009");
        var rdAccountant = new Manager(employee2, "4-010");
        
        var salesDept = new Department("Sales");
        salesDept.setDirector(salesDirector);
        salesDept.setAccountant(salesAccountant);
        var rdDept = new Department("R&D");
        rdDept.setDirector(rdDirector);
        rdDept.setAccountant(rdAccountant);
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(salesDept);
                entityManager.persist(rdDept);
            });
        }        
    }
}
