package example.jpa.one2one.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Company entity.
 * 
 * This entity demonstrates the usage of secondary tables.
 * Secondary tables share the primary key with the primary table and allow
 * to split the single table into several.
 * 
 * If the primary key column names of the secondary table don't match
 * those name of the primary table, they can be defined via the pkJoinColumns
 * attribute.
 */
@Entity
@Table(name = "companies")
@SequenceGenerator(name = "company_id_generator",
                   sequenceName = "company_id_sequence",
                   initialValue = 1,
                   allocationSize = 5)
@SecondaryTable(name = "addresses")
@SecondaryTable(name = "residence_addresses",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "company_id_generator")
    @Column(name = "company_id")
    private int id;
    
    @Column(name = "company_name")
    private String name;
    
    @Column(name = "address_string", table = "addresses")
    private String address;
    
    @Column(name = "address_string", table = "residence_addresses")
    private String residenceAddress;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

}
