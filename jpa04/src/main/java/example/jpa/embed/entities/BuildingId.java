package example.jpa.embed.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Building ID class.
 * 
 * This class models a composite primary key class as an embeddable.
 * 
 * JPA composite ID classes should implement Serializable.
 * They will also need to define equals and hashCode meaningfully.
 */
@Embeddable
public class BuildingId implements Serializable {
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
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.code);
        hash = 19 * hash + this.no;
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
        final BuildingId other = (BuildingId) obj;
        if (this.no != other.no) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

}
