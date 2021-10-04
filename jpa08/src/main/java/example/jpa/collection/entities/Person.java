package example.jpa.collection.entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;

/**
 * Person entity.
 *
 * This entity demonstrates mapping collectins. It is an alternative to
 * mapping 1-to-many relationship to a separate entity.
 */
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    // Mapping a collection of elements of a basic type.
    @ElementCollection
    @CollectionTable(name = "phones",
                     joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "number")
    private List<String> phoneNumbers;
    
    // Mapping a collection of embeddables.
    // Note that @Column doesn't apply since there are multiple columns.
    @ElementCollection
    @CollectionTable(name = "documents",
                     joinColumns = @JoinColumn(name = "person_id"))
    private Collection<Document> documents;

    public Person() {
    }

    public Person(String name) {
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }

}
