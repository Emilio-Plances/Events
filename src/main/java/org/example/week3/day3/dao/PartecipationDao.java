package org.example.week3.day3.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.week3.day3.entities.Partecipation;


public class PartecipationDao {
    private EntityManagerFactory emf;
    private EntityManager em;
    public PartecipationDao(){
        emf= Persistence.createEntityManagerFactory("manageevents");
        em= emf.createEntityManager();
    }
    public Partecipation addPartecipation(Partecipation p){
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.refresh(p);
        return p;
    }

    public Partecipation getPartecipationById(int id){
        return em.find(Partecipation.class,id);
    }
    public void deletePartecipation(int id){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove( getPartecipationById(id) );
        et.commit();
    }
}
