package example.jpa.idgen.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Event entity.
 * 
 * This entity demonstrates custom Hibernate ID generator: the UUID generator.
 */
@Entity
@Table(name = "events")
@GenericGenerator(name = "uuid_generator",
                  strategy = "org.hibernate.id.UUIDHexGenerator",
                  parameters = @Parameter(name = "separator", value = "-"))
public class Event {
    @Id
    @GeneratedValue(generator = "uuid_generator")
    private String id;
    
    @Column(nullable = false)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
