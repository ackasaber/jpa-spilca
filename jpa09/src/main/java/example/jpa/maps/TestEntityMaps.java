package example.jpa.maps;

import example.jpa.maps.entities.Professor;
import example.jpa.maps.entities.Student;
import example.jpaunit.JPAUnit;
import java.util.Map;

public class TestEntityMaps {
    public static void main(String[] args) {
        var student1 = new Student("Alex");
        var student2 = new Student("Bethany");
        var student3 = new Student("Cecilla");
        var professor1 = new Professor("Alan Heijt");
        var professor2 = new Professor("Brian Juice");

        student1.setProfessors(Map.of("Algebra", professor1,
                                      "Calculus", professor2));
        student2.setProfessors(Map.of("Algebra", professor1,
                                      "Calculus", professor1));
        student3.setProfessors(Map.of("Calculus", professor2));
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(student1);
                entityManager.persist(student2);
                entityManager.persist(student3);
            });
        }
    }
}
