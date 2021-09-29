package example.jpa.idgen;

import example.jpa.idgen.entities.User;
import example.jpaunit.JPAUnit;
import java.util.Arrays;

public class TestSequenceGenerator {

    public static void main(String[] args) {
        var user1 = new User();
        user1.setFirstName("Margaret");
        user1.setLastName("Thatcher");
        user1.setActive(false);
        
        var user2 = new User();
        user2.setFirstName("Boris");
        user2.setLastName("Johnson");
        user2.setActive(true);
        
        var user3 = new User();
        user3.setFirstName("Борис");
        user3.setLastName("Ельцин");
        user3.setActive(false);
        
        var users = new User[] { user1, user2, user3 };
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                Arrays.stream(users).forEach(entityManager::persist);
            });
        }
    }
}
