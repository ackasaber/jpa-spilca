package example.jpa.idgen;

import example.jpa.idgen.entities.Part;
import example.jpaunit.JPAUnit;
import java.util.Arrays;

public class TestIdentityGenerator {

    public static void main(String[] args) {
        var part1 = new Part();
        part1.setName("Mouse");
        part1.setCount(1);
        
        var part2 = new Part();
        part2.setName("Network card");
        part2.setCount(2);
        
        var part3 = new Part();
        part3.setName("RAM");
        part3.setCount(4);
        
        var parts = new Part[]{ part1, part2, part3 };
        
        try (var unit = new JPAUnit("mariadb-unit")) {
            unit.runTransaction(entityManager -> {
                Arrays.stream(parts).forEach(entityManager::persist);
            });
        }
    }
}
