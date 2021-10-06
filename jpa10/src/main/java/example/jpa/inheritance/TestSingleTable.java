package example.jpa.inheritance;

import example.jpa.inheritance.entities.Bug;
import example.jpa.inheritance.entities.Feature;
import example.jpa.inheritance.entities.Issue;
import example.jpaunit.JPAUnit;

public class TestSingleTable {
    public static void main(String[] args) {
        var issue = new Issue();
        issue.setTitle("Make our software great again");
        issue.setDescription("Our software is not great anymore. " +
                "This has to be sorted out!!!");
        
        var bug = new Bug();
        bug.setTitle("It doesn't work");
        bug.setDescription("Whatever I do, nothing happens.");
        bug.setSeverity(1);
        
        var feature = new Feature();
        feature.setTitle("Integrate the spreadsheet into our software");
        feature.setDescription("I feel lazy switching between windows " +
                "and it greatly reduces my productivity as a user.");
        feature.setTargetVersion("15RC");
        
        try (var unit = new JPAUnit("postgres-unit")) {
            unit.runTransaction(entityManager -> {
                entityManager.persist(issue);
                entityManager.persist(bug);
                entityManager.persist(feature);
            });
        }
    }
}
