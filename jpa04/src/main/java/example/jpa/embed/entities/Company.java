package example.jpa.embed.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Company entity.
 * 
 * This entity demonstrates usage of embeddables.
 * Column names of an embeddable can be redefined via @AttributeOverride.
 */
@Entity
@Table(name = "companies")
public class Company {
    @Id
    private String name;
    
    @Embedded
    private Address address;
    
    @Embedded
    @AttributeOverride(name = "city",
                       column = @Column(name = "residence_city"))
    @AttributeOverride(name = "street",
                       column = @Column(name = "residence_street"))
    @AttributeOverride(name = "building",
                       column = @Column(name = "residence_building"))
    private Address residenceAddress;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(Address residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

}
