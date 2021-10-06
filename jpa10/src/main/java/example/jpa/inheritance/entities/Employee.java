package example.jpa.inheritance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Employee entity.
 * 
 * This entity demonstrates table-per-entity inheritance strategy.
 * It can't be used with the IDENTITY ID generation, so a SEQUENCE generation
 * is used instead.
 */
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "employee_id_generator",
                   sequenceName = "employee_id_sequence",
                   allocationSize = 5)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "employee_id_generator")
    private int id;
    
    private String name;

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
    
}
