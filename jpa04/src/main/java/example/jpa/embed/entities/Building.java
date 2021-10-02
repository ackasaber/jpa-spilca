package example.jpa.embed.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Building entity.
 *
 * This entity demonstrates a composed ID case via {@code @EmbeddedId}.
 * The primary key colum name can be defined via {@code @AttributeOverride}.
 */
@Entity
@Table(name = "buildings")
public class Building {
    @EmbeddedId
    @AttributeOverride(name = "no",
                       column = @Column(name = "number"))
    private BuildingId id;
    private String description;

    public BuildingId getId() {
        return id;
    }

    public void setId(BuildingId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
