package com.samsung.finalproject.controller;

import com.samsung.finalproject.common.AppSettings;
import com.samsung.finalproject.models.repositories.PersonRepositoryFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    AppSettings appSettings;

    @Autowired
    PersonRepositoryFactory personFactory;

    @GetMapping("/")
    public ResponseEntity index(){
        String dataSource = appSettings.dataSource;
        String result = personFactory.getPersonRepository(dataSource).getData();

        return ResponseEntity.ok(result);
    }
}
