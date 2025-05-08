package org.largeger.day4springthymeleaf.controller;


import org.largeger.day4springthymeleaf.model.Person;
import org.largeger.day4springthymeleaf.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return personService.save(person);
    }
}
