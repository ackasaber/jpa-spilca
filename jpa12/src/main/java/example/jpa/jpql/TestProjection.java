package example.jpa.jpql;

import example.jpa.jpql.entities.EmployeeDepartment;
import example.jpaunit.JPAUnit;

public class TestProjection {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                var statement = "SELECT new example.jpa.jpql.entities.EmployeeDepartment(e.name, d.name) "
                              + "FROM Employee e JOIN e.department d";
                var query = em.createQuery(statement, EmployeeDepartment.class);
                var employees = query.getResultList();
                System.out.println("Employees:");
                employees.forEach(System.out::println);
            });
        }
    }
}
