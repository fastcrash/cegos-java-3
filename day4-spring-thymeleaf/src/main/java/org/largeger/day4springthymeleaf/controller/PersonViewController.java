package org.largeger.day4springthymeleaf.controller;


import org.largeger.day4springthymeleaf.model.Person;
import org.largeger.day4springthymeleaf.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonViewController {

    private final PersonService personService;

    public PersonViewController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("personen", personService.findAll());  // zur Darstellung aller verfügbarer Personen
        model.addAttribute("neuePerson", new Person());           // für das Add-Formular
        return "persons";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Person person = personService.findById(id).orElse(new Person());
        model.addAttribute("person", person);
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/";
    }
}
