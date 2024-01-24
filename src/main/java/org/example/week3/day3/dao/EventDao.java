package org.example.week3.day3.dao;

import org.example.week3.day3.entities.Event;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
}
