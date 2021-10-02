package example.jpa.assocoverride.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Manager {
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Employee manager;
    
    private String departmentPhone;

    public Manager() {
    }

    public Manager(Employee manager, String officePhone) {
        this.manager = manager;
        this.departmentPhone = officePhone;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }
}
