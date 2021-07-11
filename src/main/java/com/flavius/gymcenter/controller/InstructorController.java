package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.dto.InstructorDto;
import com.flavius.gymcenter.manager.InstructorManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8080")
public class InstructorController {

    private final InstructorManagerService instructorManagerService;
    public InstructorController(InstructorManagerService instructorManagerService){
        this.instructorManagerService = instructorManagerService;
    }

    @GetMapping("/findAllInstructors")
    List<InstructorDto> findAllInstructors(){
        return instructorManagerService.findAllInstructors();
    }

    @GetMapping("/findInstructorById/{id}")
    InstructorDto findInstructorById(@PathVariable long id){
        return instructorManagerService.findInstructorById(id);
    }

    @GetMapping("/findInstructorsForSport/{idSport}")
    List<InstructorDto> findInstructorsForSport(@PathVariable long idSport){
        return instructorManagerService.findInstructorForSport(idSport);
    }

    @GetMapping("/findInstructorsForGym/{idGym}")
    List<InstructorDto> findInstructorsForGym(@PathVariable long idGym){
        return instructorManagerService.findInstructorForGym(idGym);
    }

    @PostMapping("/addInstructorForGym/{idGym}")
    InstructorDto addInstructor(@RequestBody InstructorDto instructorDto, @PathVariable long idGym){
        return instructorManagerService.addInstructorForGym(instructorDto, idGym);
    }

    @PostMapping("/addInstructorForSport/{idInstructor}/{idSport}")
    void addInstructorForSport(@PathVariable long idInstructor, @PathVariable long idSport){
        instructorManagerService.addInstructorForSport(idInstructor, idSport);
    }

    @PutMapping("/editInstructor/{id}")
    InstructorDto editInstructor(@RequestBody InstructorDto instructorDto, @PathVariable long id){
        return instructorManagerService.editInstructor(instructorDto, id);
    }

    @DeleteMapping("/deleteInstructor/{id}")
    void deleteInstructor(@PathVariable long id){
        instructorManagerService.deleteInstructor(id);
    }

}
