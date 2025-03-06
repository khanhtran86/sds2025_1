package com.samsung.finalproject.models.repositories;

public class JsonPersonRepository implements IPersonRepository {
    @Override
    public String getData() {
        return "List Person from JSON";
    }
}
