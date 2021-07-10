package com.flavius.gymcenter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String city;
    private int area;
    private String logo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Worktime> worktimes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Sport> sports;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
    private List<Workout> workouts;

    public Gym() {
        super();
    }

    public Gym(String name, String address, String city, int area, String logo, List<Worktime> worktimes, List<Sport> sports, List<Instructor> instructors, List<Workout> workouts) {
        super();
        this.name = name;
        this.address = address;
        this.city = city;
        this.area = area;
        this.logo = logo;
        this.worktimes = worktimes;
        this.sports = sports;
        this.instructors = instructors;
        this.workouts = workouts;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Worktime> getWorktimes() {
        return worktimes;
    }

    public void setWorktimes(List<Worktime> worktimes) {
        this.worktimes = worktimes;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    // methods for adding worktimes, sports, instructors and workouts

    public void addWorktime(Worktime worktime) {
        if (getWorktimes() == null) {
            this.worktimes = new ArrayList<>();
        }
        getWorktimes().add(worktime);
        worktime.setGym(this);
    }

    public void addSportForGym(Sport sport) {
        if (getSports() == null) {
            this.sports = new ArrayList<>();
        }
        getSports().add(sport);
        sport.setGym(this);
    }

    public void addInstructor(Instructor instructor) {
        if (getInstructors() == null) {
            this.instructors = new ArrayList<>();
        }
        getInstructors().add(instructor);
        instructor.setGym(this);
    }

    public void addWorkout(Workout workout) {
        if (getWorkouts() == null) {
            this.workouts = new ArrayList<>();
        }
        getWorkouts().add(workout);
        workout.setGym(this);
    }

}
