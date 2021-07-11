package com.flavius.gymcenter.controller;

import com.flavius.gymcenter.model.User;
import com.flavius.gymcenter.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findUserById/{id}")
    User findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/findUserByUsername/{username}")
    Optional<User> findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping("/addUser")
    User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/editUser/{id}")
    User editUser(@RequestBody User user, @PathVariable long id) {
        return userService.editUser(user, id);
    }

    @DeleteMapping("/deleteUser/{id}")
    void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
