package example.jpa06;

import example.jpa06.entities.Department;
import example.jpa06.entities.Employee;
import example.jpaunit.JPAUnit;
import java.util.List;

public class TestOneToMany {
    public static void main(String[] args) {
        var emp1 = new Employee();
        emp1.setName("Prosecutor");
        
        var emp2 = new Employee();
        emp2.setName("Judge");
        
        var dept = new Department();
        dept.setName("Department of Punishment");
        dept.setEmployees(List.of(emp1, emp2));
        emp1.setDepartment(dept);
        emp2.setDepartment(dept);
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(dept);
                entityManager.persist(emp1);
                entityManager.persist(emp2);
            });
        }
    }
}
