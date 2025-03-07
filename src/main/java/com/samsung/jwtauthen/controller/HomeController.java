package com.samsung.jwtauthen.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    @SecurityRequirement(name = "BearerAuth")
    public ResponseEntity Test()
    {
        return ResponseEntity.ok("Hello World");
    }
}
