package example.jpa.maps.entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.Table;
import java.util.Map;

/**
 * Person entity.
 *
 * This entity demonstrates mapping maps of basic types in JPA.
 */
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    // Map the map String -> String.
    // @Column defines the value column name.
    @ElementCollection
    @CollectionTable(name = "phones",
                     joinColumns = @JoinColumn(name = "person_id"))
    @MapKeyColumn(name = "phone_type")
    @Column(name = "number")
    private Map<String, String> phones;
    
    // Map the map Enum -> String.
    // @MapKeyEnumerated instructs JPA to save the enum as text.
    // The map value can also be an enum, in this case plane @Enumerated
    // controls the map value.
    @ElementCollection
    @CollectionTable(name = "phones2",
                     joinColumns = @JoinColumn(name = "person_id"))
    @MapKeyColumn(name = "phone_type")
    @Column(name = "number")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<PhoneType, String> phones2;

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

    public Map<String, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public Map<PhoneType, String> getPhones2() {
        return phones2;
    }

    public void setPhones2(Map<PhoneType, String> phones2) {
        this.phones2 = phones2;
    }
    
}
