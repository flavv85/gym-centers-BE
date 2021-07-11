package com.flavius.gymcenter.managerImpl;

import com.flavius.gymcenter.dao.GymDao;
import com.flavius.gymcenter.dao.SportDao;
import com.flavius.gymcenter.dao.WorkoutDao;
import com.flavius.gymcenter.dto.WorkoutDto;
import com.flavius.gymcenter.manager.WorkoutManagerService;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.OrikaBeanMapper;
import com.flavius.gymcenter.model.Sport;
import com.flavius.gymcenter.model.Workout;
import com.flavius.gymcenter.service.WorkoutService;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class WorkoutManagerServiceImpl implements WorkoutManagerService {

    private final OrikaBeanMapper orikaBeanMapper;
    private final WorkoutDao workoutDao;
    private final WorkoutService workoutService;
    private final SportDao sportDao;
    private final GymDao gymDao;

    public WorkoutManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, WorkoutDao workoutDao, WorkoutService workoutService, SportDao sportDao, GymDao gymDao) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.workoutDao = workoutDao;
        this.workoutService = workoutService;
        this.sportDao = sportDao;
        this.gymDao = gymDao;
    }

    @Override
    public WorkoutDto addWorkoutForGym(WorkoutDto workoutDto, long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        Workout workout = orikaBeanMapper.map(workoutDto, Workout.class);
        return orikaBeanMapper.convertDTO(workoutService.addWorkout(workout, gym), WorkoutDto.class);
    }

    @Override
    public WorkoutDto editWorkout(WorkoutDto workoutDto, long id) {
        Workout workout = orikaBeanMapper.map(workoutDto, Workout.class);
        Workout existsWorkout = workoutDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(workoutService.editWorkout(workout, existsWorkout), WorkoutDto.class);
    }

    @Override
    public WorkoutDto findWorkoutById(long id) {
        return orikaBeanMapper.map(workoutDao.findById(id).orElse(null), WorkoutDto.class);
    }

    @Override
    public void addWorkoutForSport(long idWorkout, long idSport) {
    Workout workout = workoutDao.findById(idWorkout).orElse(null);
    Sport sport = sportDao.findById(idSport).orElse(null);
    sport.addWorkout(workout);
    }

    @Override
    public void deleteWorkout(long id) {
    Workout existsWorkout = workoutDao.findById(id).orElse(null);
    workoutDao.delete(existsWorkout);
    }

    @Override
    public List<WorkoutDto> findAllWorkouts() {
        List<Workout> workouts = workoutDao.findAll();
        return orikaBeanMapper.convertListDTO(workouts, WorkoutDto.class);
    }
}
