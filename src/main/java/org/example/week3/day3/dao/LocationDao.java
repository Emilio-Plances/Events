package org.example.week3.day3.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.week3.day3.entities.Location;

public class LocationDao {
    private EntityManagerFactory emf;
    private EntityManager em;
    public LocationDao(){
        emf= Persistence.createEntityManagerFactory("manageevents");
        em= emf.createEntityManager();
    }

    public Location addLocation(Location l){
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(l);
        et.commit();
        em.refresh(l);
        return l;
    }

    public Location getLocationById(int id){
        return em.find(Location.class,id);
    }
    public void deleteLocation(int id){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove( getLocationById(id) );
        et.commit();
    }
}
