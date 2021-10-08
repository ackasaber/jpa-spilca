package example.jpa.springboot.controllers;

import example.jpa.springboot.entitites.Product;
import example.jpa.springboot.services.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @PostMapping("/add/{name}")
    void addProduct(@PathVariable("name") String name) {
        productService.addProduct(name);
    }
    
    @GetMapping("/get")
    public List<Product> findProducts() {
        return productService.findProducts();
    }
}
