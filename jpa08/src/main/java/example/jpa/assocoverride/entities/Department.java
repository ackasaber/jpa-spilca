package example.jpa.assocoverride.entities;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    @Embedded
    @AssociationOverride(name = "manager",
                         joinColumns = @JoinColumn(name = "director"))
    @AttributeOverride(name = "departmentPhone",
                       column = @Column(name = "director_dept_phone"))
    private Manager director;
    
    @Embedded
    @AssociationOverride(name = "manager",
                         joinColumns = @JoinColumn(name = "accountant"))
    @AttributeOverride(name = "departmentPhone",
                       column = @Column(name = "accountant_dept_phone"))
    private Manager accountant;

    public Department() {
    }

    public Department(String name) {
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

    public Manager getDirector() {
        return director;
    }

    public void setDirector(Manager director) {
        this.director = director;
    }

    public Manager getAccountant() {
        return accountant;
    }

    public void setAccountant(Manager accountant) {
        this.accountant = accountant;
    }
    
}
