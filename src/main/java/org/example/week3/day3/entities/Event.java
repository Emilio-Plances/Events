package org.example.month1.week3.day2.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="events")
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

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventData=" + eventData +
                ", description='" + description + '\'' +
                ", typeEvent=" + typeEvent +
                ", maxMember=" + maxMember +
                '}';
    }
}
