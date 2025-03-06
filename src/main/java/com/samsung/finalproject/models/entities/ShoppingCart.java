package com.samsung.finalproject.models.entities;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {

    @Autowired
    HttpSession session;

    private List<Person> lstItems = new ArrayList<>();

    public void AddItem(Person person) {
        lstItems.add(person);
        this.Save();
    }

    public List<Person> GetItems() {
        return lstItems;
    }

    public Person getItem(int id) {
        return lstItems.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    public void removeItem(int id) {
        Person person = getItem(id);
        lstItems.remove(person);
    }

    public int getItemCount() {
        return lstItems.size();
    }

    public void Save()
    {
        session.setAttribute("shoppingcart", lstItems);
    }

    public void Get()
    {
        this.lstItems = (List<Person>) session.getAttribute("shoppingcart");
    }
}
