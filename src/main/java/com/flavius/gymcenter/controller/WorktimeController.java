package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.dto.CustomerDto;
import com.flavius.gymcenter.dto.WorktimeDto;
import com.flavius.gymcenter.manager.WorktimeManagerService;
import com.flavius.gymcenter.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8080")
public class WorktimeController {

    private final WorktimeManagerService worktimeManagerService;

    public WorktimeController(WorktimeManagerService worktimeManagerService) {
        this.worktimeManagerService = worktimeManagerService;
    }

    @GetMapping("/findWorktimeById/{id}")
    WorktimeDto findWorktimeById(@PathVariable long id) {
        return worktimeManagerService.findWorktimeById(id);
    }

    @GetMapping("/findWorktimeForGym/{idGym}")
    List<WorktimeDto> findWorktimeForGym(@PathVariable long idGym) {
        return worktimeManagerService.findWorktimeForGym(idGym);
    }

    @GetMapping("/findCustomerForWorktime/{id}")
    List<CustomerDto> findCustomerForWorktime(@PathVariable long id) {
        return worktimeManagerService.findCustomerForWorktime(id);
    }

    @PostMapping("/addCustomerForWork/{idCustomer}/{idWorktime}")
    void addCustomerForWork(@PathVariable long idCustomer, @PathVariable long idWorktime){
        worktimeManagerService.addCustomerForWorktime(idCustomer, idWorktime);
    }
    @PostMapping("/addWorktimeForGym/{idGym}")
    WorktimeDto addWorktimeForGym(@RequestBody WorktimeDto worktimeDto, @PathVariable long idGym){
        return worktimeManagerService.addWorktimeForGym(worktimeDto, idGym);
    }

    @PutMapping("/editWorktime/{id}/{idGym}")
    WorktimeDto editWorktime(@RequestBody WorktimeDto worktimeDto, @PathVariable long id, @PathVariable long idGym){
        return worktimeManagerService.editWorktime(worktimeDto, id, idGym);
    }

    @DeleteMapping("/deleteWorktime/{id}")
    void deleteWorktime(@PathVariable long id){
        worktimeManagerService.deleteWorktime(id);
    }

}
