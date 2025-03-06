package com.samsung.finalproject.models.repositories;

import com.samsung.finalproject.models.entities.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getData();

    List<Person> searchByName(String name);
}
