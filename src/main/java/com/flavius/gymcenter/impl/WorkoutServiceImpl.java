package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.WorkoutDao;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Workout;
import com.flavius.gymcenter.service.WorkoutService;
import org.springframework.stereotype.Component;

@Component
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutDao workoutDao;

    public WorkoutServiceImpl(WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    @Override
    public Workout addWorkout(Workout workout, Gym gym) {
        gym.addWorkout(workout);
        return workoutDao.save(workout);
    }

    @Override
    public Workout editWorkout(Workout workout, Workout existsWorkout) {
        existsWorkout.setName(workout.getName());
        return workoutDao.save(existsWorkout);
    }
}
