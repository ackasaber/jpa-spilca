package example.jpa.inheritance.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Vehicle mapped superclass.
 *
 * This class demonstrates how to put common fields into a superclass.
 */
@MappedSuperclass
public abstract class Vehicle {
    // Having the ID in the mapped superclass is not recommended.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
