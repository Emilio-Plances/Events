package org.example.week3.day3.dao;

import jakarta.persistence.*;
import org.example.week3.day3.entities.Concert;
import org.example.week3.day3.entities.Event;
import org.example.week3.day3.entities.Genre;

import java.util.List;

public class EventDao {
    private EntityManagerFactory emf;
    private EntityManager em;
    public EventDao(){
        emf= Persistence.createEntityManagerFactory("manageevents");
        em= emf.createEntityManager();
    }

    public Event addEvent(Event e){
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        em.refresh(e);
        return e;
    }
    public Event getEventById(int id){
        return em.find(Event.class,id);
    }
    public void deleteEvent(int id){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove( getEventById(id) );
        et.commit();
    }
    public List<Concert> getStreamingConcert(){
        Query q=em.createQuery("SELECT c FROM concerts c where c.streaming=true");
        return q.getResultList();
    }
    public List<Concert> getConcertByGenre(Genre g){
        Query q=em.createQuery("SELECT c FROM concerts c where c.genre="+g);
        return q.getResultList();
    }
    public int getHomeWins(){
        Query q=em.createNamedQuery("getHomeWins");
         return q.getFirstResult();
    }
    public int getGuestWins(){
        Query q=em.createNamedQuery("getGuestWins");
        return q.getFirstResult();
    }
    public int getDraw(){
        Query q=em.createNamedQuery("getDraw");
        return q.getFirstResult();
    }
}
