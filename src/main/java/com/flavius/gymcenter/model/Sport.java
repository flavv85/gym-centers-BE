package com.flavius.gymcenter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private String photo;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Gym gym;

    @OneToMany(mappedBy = "sport")
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "sport")
    private List<Workout> workouts;

    public Sport(){
        super();
    }

    public Sport(String name, String description, String photo, Customer customer, Gym gym, List<Instructor> instructors, List<Workout> workouts) {
        super();
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.customer = customer;
        this.gym = gym;
        this.instructors = instructors;
        this.workouts = workouts;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
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

    // methods for adding instructors and workout

    public void addInstructor(Instructor instructor){
        if (getInstructors()==null){
            this.instructors = new ArrayList<>();
        }
        getInstructors().add(instructor);
        instructor.setSport(this);
    }

    public void addWorkout(Workout workout){
        if (getWorkouts()==null){
            this.workouts = new ArrayList<>();
        }
        getWorkouts().add(workout);
        workout.setSport(this);
    }


}
