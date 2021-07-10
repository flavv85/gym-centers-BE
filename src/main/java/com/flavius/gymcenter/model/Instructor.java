package com.flavius.gymcenter.model;

import javax.persistence.*;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Sport sport;

    @ManyToOne
    private Gym gym;

    public Instructor() {
        super();
    }

    public Instructor(String name, Sport sport, Gym gym) {
        super();
        this.name = name;
        this.sport = sport;
        this.gym = gym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
