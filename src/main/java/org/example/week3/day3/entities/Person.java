package org.example.week3.day3.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "person")
    @Column(name="partecipation_list")
    @OrderBy("event_data ASC")
    private List<Partecipation> partecipationList=new ArrayList<>();

    public Person() {}

    public Person(String name,
                  String surname,
                  String email,
                  LocalDate birthday,
                  Gender gender,
                  List<Partecipation> partecipationList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.partecipationList = partecipationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Partecipation> getPartecipationList() {
        return partecipationList;
    }

    public void addToEventList(Partecipation partecipation) {
        partecipationList.add(partecipation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", eventList=" + partecipationList +
                '}';
    }
}
