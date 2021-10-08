package example.jpa.layered.services;

import example.jpa.layered.entities.Product;
import example.jpa.layered.repositories.ProductRepository;
import example.jpaunit.JPAUnit;
import java.util.List;

public class ProductService implements AutoCloseable {
    private final JPAUnit unit;
    
    public ProductService() {
        // Passed from outside in real applications.
        unit = new JPAUnit("postgres-unit");
    }
    
    public void addProduct(String name) {
        var product = new Product();
        product.setName(name);
        unit.runTransaction(em -> {
            var repo = new ProductRepository(em);
            repo.addProduct(product); 
        });
    }

    public List<Product> findProducts() {
        var result = new Object() {
            List<Product> list;
        };
        unit.runTransaction(em -> {
            var repo = new ProductRepository(em);
            result.list = repo.findAllProducts();
        });
        return result.list;
    }

    @Override
    public void close() {
        unit.close();
    }
    
}
