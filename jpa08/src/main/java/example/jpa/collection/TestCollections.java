package example.jpa.collection;

import example.jpa.collection.entities.Document;
import example.jpa.collection.entities.Person;
import example.jpaunit.JPAUnit;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        var phones1 = List.of("756-70-76", "765-71-80", "123-45-67");
        var person1 = new Person("Лёша Попович");
        person1.setPhoneNumbers(phones1);
        var phones2 = List.of("120-99-99");
        var person2 = new Person("Добрыня Никитич");
        person2.setPhoneNumbers(phones2);
        
        var doc1 = new Document("0001", "https://www.nasa.gov/connect/ebooks/flights_of_discovery.html");
        var doc2 = new Document("0002", "https://www.nasa.gov/feature/hubble-an-overview-of-the-space-telescope/");
        var doc3 = new Document("0003", "https://www.nasa.gov/connect/ebooks/not-yet-imagined.html");
        person1.setDocuments(List.of(doc1));
        person2.setDocuments(List.of(doc2, doc3));
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(person1);
                entityManager.persist(person2);
            });
        }
    }
}
