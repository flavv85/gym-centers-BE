package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.dto.WorkoutDto;
import com.flavius.gymcenter.manager.WorkoutManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkoutController {

    private final WorkoutManagerService workoutManagerService;

    public WorkoutController(WorkoutManagerService workoutManagerService) {
        this.workoutManagerService = workoutManagerService;
    }

    @GetMapping("/findWorkoutById/{id}")
    WorkoutDto findWorkoutById(@PathVariable long id){
        return workoutManagerService.findWorkoutById(id);
    }
    @GetMapping("/findAllWorkouts")
    List<WorkoutDto> findAllWorkouts(){
        return workoutManagerService.findAllWorkouts();
    }
    @GetMapping("/findWorkoutsForSport/{idSport}")
    List<WorkoutDto> findWorkoutsForSport(@PathVariable long idSport){
        return workoutManagerService.findWorkoutsForSport(idSport);
    }
    @GetMapping("/findWorkoutsForGym/{idGym}")
    List<WorkoutDto> findWorkoutsForGym(@PathVariable long idGym){
        return workoutManagerService.findWorkoutsForGym(idGym);
    }

    @PostMapping("/addWorkoutForGym/{idGym}")
    WorkoutDto addWorkoutForGym(@RequestBody WorkoutDto workoutDto, @PathVariable long idGym){
        return workoutManagerService.addWorkoutForGym(workoutDto, idGym);
    }
    @PostMapping("/addWorkoutForSport/{idWorkout}/{idSport}")
    void addWorkoutForSport(@PathVariable long idWorkout, @PathVariable long idSport){
        workoutManagerService.addWorkoutForSport(idWorkout, idSport);
    }

    @PutMapping("/editWorkout/{id}")
    WorkoutDto editWorkout(@RequestBody WorkoutDto workoutDto, @PathVariable long id){
        return workoutManagerService.editWorkout(workoutDto, id);
    }

    @DeleteMapping("/deleteWorkout/{id}")
    void deleteWorkout(@PathVariable long id){
        workoutManagerService.deleteWorkout(id);
    }
}
