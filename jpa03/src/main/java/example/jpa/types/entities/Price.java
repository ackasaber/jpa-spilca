package example.jpa.types.entities;

import example.jpa.types.entities.enums.Currency;
import example.jpa.types.entities.enums.OfferType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * Price entity.
 * 
 * This entity demonstrates the two strategies for handling enumerations in JPA.
 */
@Entity
@Table(name = "prices")
@SequenceGenerator(name = "price_id_generator",
                   sequenceName = "prices_id_sequence",
                   initialValue = 1,
                   allocationSize = 5)
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "price_id_generator")
    private int id;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    
    @Column(name = "offer_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }
    
}
