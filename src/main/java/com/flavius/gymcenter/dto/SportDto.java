package com.flavius.gymcenter.dto;

import java.util.List;

public class SportDto {

    private long id;
    private String name;
    private String description;
    private String photo;
    private List<InstructorDto> instructors;
    private List<WorkoutDto> workouts;

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

    public List<InstructorDto> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorDto> instructors) {
        this.instructors = instructors;
    }

    public List<WorkoutDto> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutDto> workouts) {
        this.workouts = workouts;
    }
}
