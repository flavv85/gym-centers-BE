package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.dto.SportDto;
import com.flavius.gymcenter.manager.SportManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8080")
public class SportController {
    private final SportManagerService sportManagerService;

    public SportController(SportManagerService sportManagerService) {
        this.sportManagerService = sportManagerService;
    }

    @GetMapping("/findSportById/{id}")
    SportDto findSportById(@PathVariable long id){
        return sportManagerService.findSportById(id);
    }
    @GetMapping("/findSportForCustomer/{idCustomer}")
    List<SportDto> findSportForCustomer(@PathVariable long idCustomer){
        return sportManagerService.findSportForCustomer(idCustomer);
    }
    @GetMapping("/findSportForGym/{idGym}")
    List<SportDto> findSportForGym(@PathVariable long idGym){
        return sportManagerService.findSportForGym(idGym);
    }

    @PostMapping("/addSportForGym/{idGym}")
    SportDto addSportForGym(@RequestBody SportDto sportDto, @PathVariable long idGym){
        return sportManagerService.addSportFogGym(sportDto, idGym);
    }
    @PostMapping("/addSportForCustomer/{idSport}/{idCustomer}")
    void addSportForCustomer(@PathVariable long idSport, @PathVariable long idCustomer){
        sportManagerService.addSportForCustomer(idSport, idCustomer);
    }
    @PutMapping("/editSport/{id}")
    SportDto editSport(@RequestBody SportDto sportDto, @PathVariable long id){
        return sportManagerService.editSport(sportDto, id);
    }
    @DeleteMapping("/deleteSport/{id}")
    void deleteSport(@PathVariable long id){
        sportManagerService.deleteSport(id);
    }

}
