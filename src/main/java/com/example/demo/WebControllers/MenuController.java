package com.example.demo.WebControllers;

import com.example.demo.Entity.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class MenuController {

    @GetMapping("")
    public ResponseEntity<String> getPokemon() {
        return new ResponseEntity<>("poksy", HttpStatus.OK);
    }
}
