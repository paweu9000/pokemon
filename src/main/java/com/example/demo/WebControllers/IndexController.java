package com.example.demo.WebControllers;

import com.example.demo.Entity.UserData;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<UserData> index() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
