package by.aveleshko.jpa.one2one.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Product weight entity.
 * 
 * This entity demonstrates bidirectional one-to-one mapping for the case
 * when we share the parent primary key. We have to declare the ID field
 * explicitely. The mapped parent entity is mapped via @MapsId.
 */
@Entity
@Table(name = "product_weight")
public class ProductWeight {
    @Id
    @Column(name = "product_id")
    private int id;
    
    @MapsId
    @OneToOne
    // Could use @JoinColumn, but it's been already defined in the @Id field.
    private Product product;
    
    private double netto;
    
    private double brutto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

}
