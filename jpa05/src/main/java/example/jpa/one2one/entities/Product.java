package example.jpa.one2one.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * Product entity.
 *
 * This entity demonstrates 1-to-1 JPA relationship between entities.
 * By default, the join column name is constructed by taking field names of
 * the column to join and separating them with the underscore: nutrition_id.
 * This default can be overriden via @JoinColumn on top of @OneToOne.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private BigDecimal price;
    
    // Unidirectional 1-to-1 with the default column name nutrition_id.
    @OneToOne
    private NutritionInfo nutrition;
    
    // Bidirectional 1-to-1, the non-owning side.
    // Persist weight together with the product.
    @OneToOne(mappedBy = "product",
              cascade = CascadeType.PERSIST) 
    private ProductWeight weight;

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

    public NutritionInfo getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionInfo nutrition) {
        this.nutrition = nutrition;
    }

    public ProductWeight getWeight() {
        return weight;
    }

    public void setWeight(ProductWeight weight) {
        this.weight = weight;
    }
    
}
