package com.example.bank.controllers;

import com.example.bank.models.User;
import com.example.bank.models.UserResponse;
import com.example.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
        return new ResponseEntity<>(new UserResponse(user.getEmail(), user.getName()), HttpStatus.OK);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String password,
                           @RequestParam(required = false) String name) {
        userService.updateUser(userId, email, password, name);
    }

}
