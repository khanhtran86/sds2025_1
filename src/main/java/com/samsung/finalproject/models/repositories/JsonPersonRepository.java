package com.samsung.finalproject.models.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsung.finalproject.models.entities.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Repository("JsonRepository")
public class JsonPersonRepository implements IPersonRepository {
    @Override
    public List<Person> getData() {
        ObjectMapper objectMapper = new ObjectMapper(); //Map json to object
        InputStream inputStream = null;
        try {
            inputStream = new ClassPathResource("data/person.json").getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<Person>>() {});
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public List<Person> searchByName(String name) {
        List<Person> lstPerson = this.getData();
        return lstPerson.stream().filter((s)->s.getFirstName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
}
