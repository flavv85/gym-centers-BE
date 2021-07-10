package com.flavius.gymcenter.model;

import javax.persistence.*;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private Sport sport;

    @ManyToOne
    private Gym gym;

    public Workout(){
        super();
    }

    public Workout(String name, Sport sport, Gym gym) {
        super();
        this.name = name;
        this.sport = sport;
        this.gym = gym;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
