package org.example.week3.day3.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity(name="Football")
@Table(name="football_matches")
@NamedQuery(name = "getHomeWins", query = "SELECT COUNT(f) FROM football f where f.home_team=f.winning_team")
@NamedQuery(name = "getGuestWins", query = "SELECT COUNT(f) FROM football f where f.guest_team=f.winning_team")
@NamedQuery(name = "getDraw", query = "SELECT COUNT(f) FROM football f where f.winning_team=NULL")
public class FootballMatch extends Event{
    @Column(name="home_team")
    private String homeTeam;
    @Column(name="guest_team")
    private String guestTeam;
    @Column(name="winning_team")
    private String winningTeam;
    @Column(name="home_goals")
    private int homeGoals;
    @Column(name="guest_goals")
    private int guestGoals;
    public FootballMatch() {}
    public FootballMatch(String title, LocalDate eventData, String description, TypeEvent typeEvent, int maxMember, String homeTeam, String guestTeam, int homeGoals, int guestGoals) {
        super(title, eventData, description, typeEvent, maxMember);
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
        winner();
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public String getGuestTeam() {
        return guestTeam;
    }
    public String getWinningTeam() {

        return winningTeam;
    }
    public int getHomeGoals() {
        return homeGoals;
    }
    public int getGuestGoals() {
        return guestGoals;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
        winner();
    }
    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
        winner();
    }
    public void setGuestGoals(int guestGoals) {
        this.guestGoals = guestGoals;

    }
    public void winner(){
        if(homeGoals>guestGoals) winningTeam = homeTeam;
        else if(homeGoals<guestGoals) winningTeam=guestTeam;
    }
}
