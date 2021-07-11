package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.dto.GymDto;
import com.flavius.gymcenter.manager.GymManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8080")
public class GymController {

    private final GymManagerService gymManagerService;

    public GymController(GymManagerService gymManagerService){
        this.gymManagerService = gymManagerService;
    }

    @GetMapping("/findAllGyms")
    List<GymDto> findAllGyms(){
        return gymManagerService.findAllGyms();
    }

    @GetMapping("/findGymById/{id}")
    GymDto findGymById(@PathVariable long id){
        return gymManagerService.findGymById(id);
    }

    @PostMapping("/addGym")
    GymDto addGym(@RequestBody GymDto gymDto){
        return gymManagerService.addGym(gymDto);
    }

    @PutMapping("/editGym/{id}")
    GymDto editGym(@RequestBody GymDto gymDto, @PathVariable long id){
        return gymManagerService.editGym(gymDto, id);
    }
    @DeleteMapping("/deleteGym/{id}")
    void deleteGym(@PathVariable long id){
        gymManagerService.deleteGym(id);
    }

}
