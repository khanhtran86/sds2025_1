package com.samsung.finalproject.models.repositories;

public class PersonRepository implements IPersonRepository {
    @Override
    public String getData() {
        return "List Person from DB";
    }
}
