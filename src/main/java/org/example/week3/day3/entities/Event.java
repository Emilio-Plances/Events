package org.example.week3.day3.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="events")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 20)
    private String title;
    @Column(name = "event_data")
    private LocalDate eventData;
    @Column(length = 100)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name="type_event")
    private TypeEvent typeEvent;
    @Column(name="max_member")
    private int maxMember;
    @ManyToOne
    @JoinColumn(name="location_fk")
    private Location location;
    @OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
    private List<Partecipation> partecipation;

    public Event(String title,
                 LocalDate eventData,
                 String description,
                 TypeEvent typeEvent,
                 int maxMember){
        this.title = title;
        this.eventData = eventData;
        this.description = description;
        this.typeEvent = typeEvent;
        this.maxMember = maxMember;
    }
    public Event(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventData() {
        return eventData;
    }

    public void setEventData(LocalDate eventData) {
        this.eventData = eventData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeEvent getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(TypeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }

    public int getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(int maxMember) {
        this.maxMember = maxMember;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventData=" + eventData +
                ", description='" + description + '\'' +
                ", typeEvent=" + typeEvent +
                ", maxMember=" + maxMember;
    }
}
