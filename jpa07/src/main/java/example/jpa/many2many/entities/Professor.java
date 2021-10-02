package example.jpa.many2many.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Professor entity.
 * 
 * This entity demonstrates bi-directional many-to-many relationship in JPA.
 * The unidirectional relationship is achieved by dropping {@code @ManyToMany}
 * field on the other entity ({@code Student} in this case).
 */
@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    @ManyToMany
    @JoinTable(name = "enrollment",
               joinColumns = @JoinColumn(name = "professor_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Professor() {
    }
    
    public Professor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", name=" + name + '}';
    }
    
}
