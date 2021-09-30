package example.jpa.many2many;

import example.jpa.many2many.entities.Professor;
import example.jpa.many2many.entities.Student;
import example.jpaunit.JPAUnit;
import java.util.List;

public class TestManyToMany {
    public static void main(String[] args) {
        var student1 = new Student("Alex");
        var student2 = new Student("Beth");
        var student3 = new Student("Cate");
        var professor1 = new Professor("Albert Einstein");
        var professor2 = new Professor("Steven Howking");
        professor1.setStudents(List.of(student1, student2));
        professor2.setStudents(List.of(student2, student3));
        // need to set relationships consistently for the bi-directional mapping
        student1.setProfessors(List.of(professor1));
        student2.setProfessors(List.of(professor1, professor2));
        student3.setProfessors(List.of(professor2));
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(student1);
                entityManager.persist(student2);
                entityManager.persist(student3);
                entityManager.persist(professor1);
                entityManager.persist(professor2);
            });
        }
    }
}
