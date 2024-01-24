package org.example.week3.day3.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.week3.day3.entities.Person;

public class PersonDao {
    private EntityManagerFactory emf;
    private EntityManager em;
    public PersonDao(){
        emf= Persistence.createEntityManagerFactory("manageevents");
        em= emf.createEntityManager();
    }
    public Person addPerson(Person p){
        EntityTransaction et= em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.refresh(p);
        return p;
    }

    public Person getPersonById(int id){
        return em.find(Person.class,id);
    }
    public void deletePerson(int id){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove( getPersonById(id) );
        et.commit();
    }
}
