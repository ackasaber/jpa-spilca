package example.jpa.one2one;

import example.jpa.one2one.entities.Company;
import example.jpaunit.JPAUnit;

public class TestSecondaryTables {
    public static void main(String[] args) {
        var company1 = new Company();
        company1.setName("EPAM Ukraine");
        company1.setAddress("Київ, Кудряшова, 14Б");
        company1.setResidenceAddress("Київ, Сім'ї Прахових, 54");
        
        var company2 = new Company();
        company2.setName("EPAM SISTEMOS");
        company2.setResidenceAddress("Vilnius, J. Jasinskio, 16B");
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(company1);
                entityManager.persist(company2);
            });
        }
    }
}
