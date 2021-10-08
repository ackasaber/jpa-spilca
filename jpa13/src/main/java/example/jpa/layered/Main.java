package example.jpa.layered;

import example.jpa.layered.services.ProductService;

public class Main {
    public static void main(String[] args) {
        try (var service = new ProductService()) {
            service.addProduct("Chocolate");
            service.addProduct("Nissan");
            System.out.println(service.findProducts());
        }
    }
}
