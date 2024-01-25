package org.example.week3.day3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="athletic_Competitions")
public class AthleticCompetition extends Event{
    @OneToMany(mappedBy = "athletes")
    private List<Person> athletes;
    @OneToOne()
    @JoinColumn(name = "person_fk")
    private Person winner;
    public AthleticCompetition() {
    }
    public AthleticCompetition(String title, LocalDate eventData, String description, TypeEvent typeEvent, int maxMember, List<Person> athletes, Person winner) {
        super(title, eventData, description, typeEvent, maxMember);
        this.athletes = athletes;
        this.winner = winner;
    }
    public List<Person> getAthletes() {
        return athletes;
    }
    public void setAthletes(List<Person> athletes) {
        this.athletes = athletes;
    }
    public Person getWinner() {
        return winner;
    }
    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return super.toString()+
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
