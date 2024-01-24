package org.example.week3.day3;

import org.example.week3.day3.dao.EventDao;
import org.example.week3.day3.dao.LocationDao;
import org.example.week3.day3.dao.PartecipationDao;
import org.example.week3.day3.dao.PersonDao;
import org.example.week3.day3.entities.*;
public class Use {
    public static void main(String[] args) {
        EventDao eventDao=new EventDao();
        LocationDao locationDao=new LocationDao();
        PartecipationDao partecipationDao=new PartecipationDao();
        PersonDao personDao=new PersonDao();

        Event e1=new Event();
        Event e2=new Event();
        Event e3=new Event();
        e1.setTitle("Festa");
        e2.setTitle("Concerto");
        e3.setTitle("Matrimonio");

        Location l1=new Location("Piazza San Marco","Venezia");
        Location l2=new Location("Piazza del Plebiscito","Napoli");
        e1.setLocation(l1);
        e2.setLocation(l2);
        e3.setLocation(l1);

        Person p1=new Person();
        Person p2=new Person();
        p1.setName("Emilio");
        p2.setName("Mauro");

        Partecipation par1=new Partecipation();
        Partecipation par2=new Partecipation();
        Partecipation par3=new Partecipation();
        Partecipation par4=new Partecipation();

        par1.setEvent(e1);par1.setPerson(p1);
        par2.setEvent(e2);par2.setPerson(p2);
        par3.setEvent(e1);par3.setPerson(p2);
        par4.setEvent(e2);par4.setPerson(p1);

        personDao.addPerson(p1);
        personDao.addPerson(p2);
        locationDao.addLocation(l1);
        locationDao.addLocation(l2);
        eventDao.addEvent(e1);
        eventDao.addEvent(e2);
        eventDao.addEvent(e3);

        partecipationDao.addPartecipation(par1);
        partecipationDao.addPartecipation(par2);
        partecipationDao.addPartecipation(par3);
        partecipationDao.addPartecipation(par4);

        Person p4=personDao.getPersonById(1);
        System.out.println(p4.getPartecipationList());
    }
}
