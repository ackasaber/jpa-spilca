package example.jpa.maps;

import example.jpa.maps.entities.Student;
import example.jpaunit.JPAUnit;

public class CheckEntityMaps {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                var student1 = entityManager.find(Student.class, 1);
                var student2 = entityManager.find(Student.class, 2);
                var student3 = entityManager.find(Student.class, 3);
                System.out.println(student1);
                System.out.println(student2);
                System.out.println(student3);
            });
        }
    }
}
