package example.jpa.jpql.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * Product entity.
 *
 * An entity for example JPQL queries. Named queries are also demonstrated.
 */
@Entity
@Table(name = "products")
// Named query names are dotted as a convention, not as a required syntax.
@NamedQuery(name = "Product.all",
            query = "SELECT p FROM Product p")
@NamedQuery(name = "Product.findByName",
            query = "SELECT p FROM Product p WHERE p.name = :name")
public class Product {
    @Id
    private int id;
    
    private String name;
    
    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
}
