package com.samsung.finalproject.models.repositories;

import com.samsung.finalproject.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> getPersonByFirstNameContaining(String firstName);
}
