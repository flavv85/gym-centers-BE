package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.WorkoutDto;

import java.util.List;

public interface WorkoutManagerService {
    WorkoutDto addWorkoutForGym(WorkoutDto workoutDto, long idGym);
    WorkoutDto editWorkout(WorkoutDto workoutDto, long id);
    WorkoutDto findWorkoutById(long id);
    void addWorkoutForSport(long idWorkout, long idSport);
    void deleteWorkout(long id);
    List<WorkoutDto> findAllWorkouts();
    List<WorkoutDto> findWorkoutsForSport(long idSport);
    List<WorkoutDto> findWorkoutsForGym(long idGym);
}
