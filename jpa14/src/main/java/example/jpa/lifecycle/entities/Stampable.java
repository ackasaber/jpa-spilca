package example.jpa.lifecycle.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Stampable mapped superclass.
 *
 * A good example of a mapped superclass: encapsulate created and modified
 * timestamps on the JPA level. (An alternative is to do this in the database.)
 */
@MappedSuperclass
public abstract class Stampable {
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    
    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "Stampable{" + "dateCreated=" + dateCreated + ", lastModified=" + lastModified + '}';
    }

    @PrePersist
    public void prepersist() {
        dateCreated = LocalDateTime.now();
        lastModified = dateCreated;
    }
    
    @PreUpdate
    public void preupdate() {
        lastModified = LocalDateTime.now();
    }
    
}
