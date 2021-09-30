package example.jpa.many2many;

import example.jpa.many2many.entities.Professor;
import example.jpa.many2many.entities.Student;
import example.jpaunit.JPAUnit;

public class ReadStudents {
    public static void main(String[] args) {
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                var professor = entityManager.find(Professor.class, 1);
                System.out.println("Professor 1: " + professor.getName());
                var students = professor.getStudents();
                System.out.println("Students: ");
                students.stream().forEach(System.out::println);
                
                var student = entityManager.find(Student.class, 2);
                System.out.println("Student 2: " + student.getName());
                var professors = student.getProfessors();
                System.out.println("Professors:");
                professors.stream().forEach(System.out::println);
            });
        }
    }
}
