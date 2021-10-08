package example.jpa.layered.repositories;

import example.jpa.layered.entities.Product;
import example.jpaunit.JPAUnit;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class ProductRepository {
    
    private final EntityManager em;
    
    public ProductRepository(EntityManager em) {
        this.em = Objects.requireNonNull(em);
    }
    
    public void addProduct(Product product) {
        em.persist(product);
    }
    
    public List<Product> findAllProducts() {
        var query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();        
    }
}
