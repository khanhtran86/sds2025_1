package com.samsung.finalproject.models.repositories;

import com.samsung.finalproject.models.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DBRepository")
public class DBPersonRepository implements IPersonRepository {
    @Autowired
    PersonRepository personRepo;

    @Override
    public List<Person> getData() {
        return personRepo.findAll();
    }

    @Override
    public List<Person> searchByName(String name) {
        return personRepo.getPersonByFirstNameContaining(name);
    }
}
