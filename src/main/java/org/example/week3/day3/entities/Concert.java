package org.example.week3.day3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="concerts")
public class Concert extends Event{
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean streaming;

    public Concert() {
    }
    public Concert(String title, LocalDate eventData, String description, TypeEvent typeEvent, int maxMember, Genre genre, boolean streaming) {
        super(title, eventData, description, typeEvent, maxMember);
        this.genre = genre;
        this.streaming = streaming;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return super.toString()+
                "genre=" + genre +
                ", streaming=" + streaming +
                '}';
    }
}
