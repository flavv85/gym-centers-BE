package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Workout;

public interface WorkoutService {
    Workout addWorkout(Workout workout, Gym gym);

    Workout editWorkout(Workout workout, Workout existsWorkout);
}
