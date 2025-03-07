package com.samsung.finalproject.controller;

import com.samsung.finalproject.models.entities.Person;
import com.samsung.finalproject.models.entities.ShoppingCart;
import com.samsung.finalproject.models.viewmodels.Users;
import com.samsung.finalproject.services.PersonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    PersonService personService;
    ShoppingCart shoppingCart;
    public HomeController(PersonService personService, ShoppingCart shoppingCart) {
        this.personService = personService;
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<Person> result =personService.getPersonList();

        model.addAttribute("persons", result);
        session.setAttribute("personList", result);

        return "ListPersons";
    }

    @GetMapping("/addtocart")
    public String addToCart(int id)
    {
        Person person = personService.getPersonList().stream().filter(p->p.getId()==id).findFirst().get();
        shoppingCart.AddItem(person);
        return "redirect:/shoppingcart";
    }

    @GetMapping("/shoppingcart")
    public String shoppingcart(Model model)
    {
        List<Person> result = shoppingCart.GetItems();
        model.addAttribute("persons", result);
        return "ListPersons";
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(defaultValue = "") String name)
    {
        List<Person> result = personService.searchPerson(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getsession")
    public ResponseEntity getSession(HttpSession session) {
        List<Person> lstPerson = (List<Person>)session.getAttribute("personList");
        return ResponseEntity.ok(lstPerson);
        //return ResponseEntity.ok(session.getId());
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        Users user = new Users();
        model.addAttribute("user", user);

        return "Login";
    }
}
