package org.example.week3.day3.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String citta;
    @OneToMany
    @OrderBy("event_data ASC")
    private List<Event> events=new ArrayList<>();
    public Location(){}

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }
}
