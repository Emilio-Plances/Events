package org.example.week3.day3;

import org.example.week3.day3.dao.EventDao;
import org.example.week3.day3.entities.Event;
import org.example.week3.day3.entities.TypeEvent;

import java.time.LocalDate;

public class UseEvent {
    public static void main(String[] args) {
        EventDao event=new EventDao();

        LocalDate data=LocalDate.of(2024,1,28);
        Event e=new Event("Prove Concerto",data,"Le prove di un bel concerto", TypeEvent.PUBLIC,500);

        System.out.println(event.addEvent(e));

        System.out.println(event.getEventById(1));
        event.deleteEvent(1);
    }
}
