package example.jpa.springboot.services;

import example.jpa.springboot.entitites.Product;
import example.jpa.springboot.repositories.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Product service class.
 * 
 * Spring will inject the Spring Data JPA repository implementation
 * via constructor injection. Transaction handling code is added due of the
 * {@code @Transactional} annotation.
 */
@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public void addProduct(String name) {
        var product = new Product();
        product.setName(name);
        productRepository.save(product);
    }
    
    public List<Product> findProducts() {
        return productRepository.findAll();
    }
    
    public List<Product> findProducts(String name) {
        return productRepository.findProductsByName(name);
    }
}
