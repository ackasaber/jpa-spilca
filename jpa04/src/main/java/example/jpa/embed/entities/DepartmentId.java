package example.jpa.embed.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Department ID class.
 * 
 * This class models a composite primary key class as the reference to
 * {@code @IdClass} annotation.
 * 
 * JPA composite ID classes should implement Serializable.
 * They will also need to define equals and hashCode meaningfully.
 */
public class DepartmentId implements Serializable {
    private String code;
    private int no;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.code);
        hash = 23 * hash + this.no;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DepartmentId other = (DepartmentId) obj;
        if (this.no != other.no) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
}
