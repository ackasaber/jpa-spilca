package example.jpa.lifecycle.entities;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;

/**
 * Product entity.
 * 
 * This entity demonstrates persistence events.
 * The following events are available:
 * 
 * <ul>
 * <li>{@code @PostLoad},</li>
 * <li>{@code @PreUpdate}, {@code @PostUpdate},</li>
 * <li>{@code @PrePersist}, {@code @PostPersist},</li>
 * <li>{@code @PreRemove}, {@code @PostRemove}.</li>
 * </ul>
 */
@Entity
@Table(name = "products")
@Cacheable
public class Product extends Stampable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name
                          + ", stamps = " + super.toString() + "}";
    }
    
    @PostLoad
    public void postload() {
        System.out.println("PostLoad " + this);
    }
    
    @PreRemove
    public void preremove() {
        System.out.println("PreRemove " + this);
    }
    
    @PostRemove
    public void postremove() {
        System.out.println("PostRemove " + this);
    }
}
