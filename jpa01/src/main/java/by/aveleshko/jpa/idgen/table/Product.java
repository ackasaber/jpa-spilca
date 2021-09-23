package by.aveleshko.jpa.idgen.table;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@TableGenerator(name = "key_generator",
                table = "key_gen",
                pkColumnName = "entity_name",
                pkColumnValue = "products",
                valueColumnName = "next_id",
                initialValue = 1,
                allocationSize = 10)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    private int id;
    
    @Basic(optional = false)
    private String name;
    
    @Basic(optional = false)
    private BigDecimal price;
    
    // optional is a hint, nullable is not?
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
