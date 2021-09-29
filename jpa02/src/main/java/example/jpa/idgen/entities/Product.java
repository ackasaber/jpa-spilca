package example.jpa.idgen.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Product entity.
 * 
 * This entity demonstrates the TABLE ID generation strategy.
 */
@Entity
@Table(name = "products")
@TableGenerator(name = "table_generator",
                table = "next_id_table",
                pkColumnName = "entity_name",
                pkColumnValue = "products",
                valueColumnName = "next_id",
                initialValue = 1,
                allocationSize = 10)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
    private int id;
    
    // There is also @Basic(optional = true),
    // but it's just a scheme generation hint.
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    
}
