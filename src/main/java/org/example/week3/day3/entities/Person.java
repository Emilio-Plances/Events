package org.example.week3.day3.entities;


import jakarta.persistence.*;

@Entity
@Table(name="persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String
}
