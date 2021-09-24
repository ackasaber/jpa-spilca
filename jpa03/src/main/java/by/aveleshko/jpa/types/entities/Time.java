package by.aveleshko.jpa.types.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Time entity.
 * 
 * This entity demonstrates various date and time types supported by JPA.
 * Note that the zone info is dropped from ZonedDateTime with Hibernate.
 * (No idea who would care about it though, since storing zone info per date
 * seems impractical.)
 */
@Entity
@Table(name = "times")
@SequenceGenerator(name = "time_id_generator",
                   sequenceName = "time_id_sequence",
                   allocationSize = 1)
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "time_id_generator")
    private int id;
    
    @Column(name = "date_column")
    private LocalDate date;
    
    @Column(name = "time_column")
    private LocalTime time;
    
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    
    @Column(name = "date_time2")
    private ZonedDateTime dateTime2;
    
    @Column(name = "zdate_time")
    private ZonedDateTime zonedDateTime;
    
    @Column(name = "legacy_date")
    @Temporal(TemporalType.DATE)
    private Date legacyDate;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ZonedDateTime getDateTime2() {
        return dateTime2;
    }

    public void setDateTime2(ZonedDateTime dateTime2) {
        this.dateTime2 = dateTime2;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public Date getLegacyDate() {
        return legacyDate;
    }

    public void setLegacyDate(Date legacyDate) {
        this.legacyDate = legacyDate;
    }
    
}
