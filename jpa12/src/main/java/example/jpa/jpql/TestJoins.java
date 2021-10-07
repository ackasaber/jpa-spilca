package example.jpa.jpql;

import example.jpa.jpql.entities.Employee;
import example.jpaunit.JPAUnit;

public class TestJoins {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(em -> {
                // Need to be careful with N + 1 problem when
                // doing JPQL queries. Consider using LAZY fetch type
                // and JOIN FETCH in the JPQL.
                var statement = "SELECT e FROM Employee e JOIN e.department d " +
                                "WHERE d.name = :department";
                var query = em.createQuery(statement, Employee.class);
                query.setParameter("department", "R&D");
                var employees = query.getResultList();
                System.out.println("R&D employees:");
                employees.forEach(System.out::println);
            });
        }
    }
}
