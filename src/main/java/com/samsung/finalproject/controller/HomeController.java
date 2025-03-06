package com.samsung.finalproject.controller;

import com.samsung.finalproject.models.entities.Person;
import com.samsung.finalproject.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    PersonService personService;
    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public ResponseEntity index(){
        List<Person> result =personService.getPersonList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(defaultValue = "") String name)
    {
        List<Person> result = personService.searchPerson(name);
        return ResponseEntity.ok(result);
    }
}
