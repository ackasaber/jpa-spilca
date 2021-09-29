package example.jpa.types;

import example.jpa.types.entities.Time;
import example.jpaunit.JPAUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class TestTime {

    public static void main(String[] args) {
        var time1 = new Time();
        time1.setDate(LocalDate.now());
        time1.setTime(LocalTime.now());
        time1.setDateTime(LocalDateTime.now());
        var zdt = ZonedDateTime.now();
        time1.setDateTime2(zdt);
        time1.setZonedDateTime(zdt);
                
        var time2 = new Time();
        var zdt2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        time2.setDateTime2(zdt2);
        time2.setZonedDateTime(zdt2);
        time2.setLegacyDate(new Date());
        
        try (var jpaUnit = new JPAUnit("postgres-unit")) {
            jpaUnit.runTransaction(entityManager -> {
                entityManager.persist(time1);
                entityManager.persist(time2);
            });
        }
    }
}
