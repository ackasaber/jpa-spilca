package by.aveleshko.jpa.embed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * Department entity.
 * 
 * This entity demonstrate a composed key case via @IdClass.
 * Primary column names are defined via the usual @Column annotation.
 */
@Entity
@Table(name = "departments")
@IdClass(DepartmentId.class)
public class Department {
    @Id
    private String code;
    
    @Id
    @Column(name = "number")
    private int no;
    
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
