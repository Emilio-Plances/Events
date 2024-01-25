package org.example.week3.day3.entities;

import jakarta.persistence.*;

@Entity
@Table(name="partecipation")
public class Partecipation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name="person_fk")
    private Person person;
    @ManyToOne
    @JoinColumn(name="event_fk")
    private Event event;
    @Enumerated(EnumType.STRING)
    private State state;

    public Partecipation(Person person, Event event) {
        this.person = person;
        this.event = event;
    }

    public Partecipation() {}

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                '}';
    }
}
