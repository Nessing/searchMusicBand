package ru.nessing.searchmusicband.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nessing.searchmusicband.entities.User;
import ru.nessing.searchmusicband.services.AppService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class AppController {
    private final AppService appService;

    @GetMapping("test/{test}")
    public String test(@PathVariable String test) {
        return test;
    }

    @GetMapping("/id/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        return appService.findUserById(id);
    }

    @GetMapping("/email/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return appService.findUserByEmail(email);
    }

    @PostMapping("/updateState/{email}{password}{state}")
    public User updateState(@PathVariable String email, String password, String state) {
        return appService.updateState(email, password, state);
    }

    @PostMapping
    public String saveNewUser(@RequestBody User user) {
        user.setId(null);
        return appService.saveOrUpdateUser(user);
    }
}
