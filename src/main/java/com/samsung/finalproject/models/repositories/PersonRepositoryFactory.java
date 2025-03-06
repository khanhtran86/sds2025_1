package com.samsung.finalproject.models.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class PersonRepositoryFactory {
    public IPersonRepository getPersonRepository(String type) {
        if(type.equalsIgnoreCase("json")) {
            return new JsonPersonRepository();
        }
        return new PersonRepository();
    }
}
