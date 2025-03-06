package com.samsung.finalproject.services;

import com.samsung.finalproject.common.AppSettings;
import com.samsung.finalproject.models.entities.Person;
import com.samsung.finalproject.models.repositories.IPersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;

import java.util.List;

@Service
public class PersonService {
    IPersonRepository personRepository;

    public PersonService(AppSettings appSettings, ApplicationContext appContext) {
        String dataSource = appSettings.dataSource;

        if(dataSource.equalsIgnoreCase("json")) {
            this.personRepository = appContext.getBean("JsonRepository", IPersonRepository.class);
        }
        else
            this.personRepository = appContext.getBean("DBRepository", IPersonRepository.class);

    }

    public List<Person> getPersonList()
    {
        return personRepository.getData();
    }

    public List<Person> searchPerson(String name)
    {
        return personRepository.searchByName(name);
    }
}
