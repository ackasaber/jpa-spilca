package example.jpa.maps;

import example.jpa.maps.entities.Person;
import example.jpa.maps.entities.PhoneType;
import example.jpaunit.JPAUnit;
import java.util.Map;

public class TestBasicMaps {
    public static void main(String[] args) {
        var p1 = new Person("Adam Smith");
        p1.setPhones(Map.of("Home", "145-05-71",
                            "Work", "765-99-99"));
        p1.setPhones2(Map.of(PhoneType.HOME, "145-05-71",
                            PhoneType.WORK, "765-99-99"));
        var p2 = new Person("Alan Presley");
        p2.setPhones(Map.of("Work", "501-75-99"));
        p2.setPhones2(Map.of(PhoneType.WORK, "501-75-99"));
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
               entityManager.persist(p1);
               entityManager.persist(p2);
            });
        }
    }
}
