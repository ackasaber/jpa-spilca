package by.aveleshko.jpa.idgen;

import by.aveleshko.jpa.idgen.entities.Event;
import by.aveleshko.jpaunit.JPAUnit;
import java.util.Arrays;

public class TestUUIDGenerator {

    public static void main(String[] args) {
        var eventDescriptions = new String[] {
            "The system started up",
            "The user logged in",
            "The user logged out",
            "The system shut down"
        };
        var events = new Event[eventDescriptions.length];
        
        for (int i = 0; i < eventDescriptions.length; ++i) {
            var event = new Event();
            event.setDescription(eventDescriptions[i]);
            events[i] = event;
        }
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                Arrays.stream(events).forEach(entityManager::persist);
            });
        }
    }
}
