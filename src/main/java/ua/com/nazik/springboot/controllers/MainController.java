package ua.com.nazik.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.nazik.springboot.dao.UserDAO;
import ua.com.nazik.springboot.models.User;

@Controller
public class MainController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("OKindex");
        return "index";
    }

    @PostMapping("/registration")
    public String registration(Model model) {

        System.out.println("OKregistration");
        return "registration";
    }

    @PostMapping("/baza")
    public String baza(Model model) {

        model.addAttribute("allUsers",userDAO.findAll());
        System.out.println("OKbaza");
        return "baza";
    }

    @PostMapping("/result")
    public String result(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String password,
            Model model
    ) {
        userDAO.save(new User(name, surname, email, password));
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        System.out.println("OKresult");
        return "result";
    }

    @GetMapping("/user-{xxx}")
    public String single(@PathVariable("xxx") int id, Model model) {
        model.addAttribute("currentUser", userDAO.findById(id).get());
        System.out.println("OKsingle");
        return "single";
    }
}
