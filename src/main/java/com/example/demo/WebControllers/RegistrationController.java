package com.example.demo.WebControllers;

import com.example.demo.Entity.UserData;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity<UserData> saveUser(@Valid @RequestBody UserData user) {
        userService.saveUser(user);
        userService.saveToFile();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
