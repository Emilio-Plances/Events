package org.example.week3.day3;

import org.example.week3.day3.dao.EventDao;
import org.example.week3.day3.dao.LocationDao;
import org.example.week3.day3.dao.PartecipationDao;
import org.example.week3.day3.dao.PersonDao;
public class Use {
    public static void main(String[] args) {
        EventDao eventDao=new EventDao();
        LocationDao locationDao=new LocationDao();
        PartecipationDao partecipationDao=new PartecipationDao();
        PersonDao personDao=new PersonDao();

    }
}
