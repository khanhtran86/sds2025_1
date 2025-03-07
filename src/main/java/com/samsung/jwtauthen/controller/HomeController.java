package com.samsung.jwtauthen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity Test()
    {
        return ResponseEntity.ok("Hello World");
    }
}
