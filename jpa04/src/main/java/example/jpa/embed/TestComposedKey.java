package example.jpa.embed;

import example.jpa.embed.entities.Building;
import example.jpa.embed.entities.BuildingId;
import example.jpa.embed.entities.Department;
import example.jpaunit.JPAUnit;

public class TestComposedKey {
    public static void main(String[] args) {
        var dep = new Department();
        dep.setCode("DPT");
        dep.setNo(17);
        dep.setName("Department of Small Affairs");
        
        var buildingId = new BuildingId();
        buildingId.setCode("B");
        buildingId.setNo(54);
        var building = new Building();
        building.setId(buildingId);
        building.setDescription("House of Executions");
        
        try (var jpaUnit = new JPAUnit("postgres-unit")) {
            jpaUnit.runTransaction(entityManager -> {
                entityManager.persist(dep);
                entityManager.persist(building);
            });
        }
    }
}
