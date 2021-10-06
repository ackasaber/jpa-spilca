package example.jpa.maps.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import java.util.Map;

/**
 * Student entity.
 * 
 * This entity demonstrates a unidirectional many-to-many relationship
 * stored in a map. (JPA doesn't support bidirectional many-to-many
 * relationships with the map on both sides.)
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    // Assuming the course is lectured by a single professor
    // and students can't take the same course from the other professors.
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "enrollment",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "professor_id"))
    @MapKeyColumn(name = "course")
    private Map<String, Professor> professors;

    public Student() {
    }

    public Student(String name) {
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

    public Map<String, Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Map<String, Professor> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", professors=" + professors + '}';
    }
    
}
