package by.aveleshko.jpa.embed;

import by.aveleshko.jpa.embed.entities.Address;
import by.aveleshko.jpa.embed.entities.Company;
import by.aveleshko.jpaunit.JPAUnit;

public class TestEmbedded {
    public static void main(String[] args) {
        var address = new Address();
        address.setCity("Київ");
        address.setStreet("Кудряшова");
        address.setBuilding("14Б");
        
        var resAddress = new Address();
        resAddress.setCity("Київ");
        resAddress.setStreet("Сім'ї Прахових");
        resAddress.setBuilding("54");
        
        var company = new Company();
        company.setName("EPAM Ukraine");
        company.setAddress(address);
        company.setResidenceAddress(resAddress);
        
        try (var jpaUnit = new JPAUnit("postgres-unit")) {
            jpaUnit.runTransaction(entityManager -> {
                entityManager.persist(company);
            });
        }
    }
}
