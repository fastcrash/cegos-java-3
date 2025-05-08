package org.largeger.day4springthymeleaf.service;


import org.largeger.day4springthymeleaf.model.Person;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final Map<Long, Person> personen = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Person> findAll() {
        return new ArrayList<>(personen.values());
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(personen.get(id));
    }

    public Person save(Person person) {
        if (person.getId() == null) {
            person.setId(idGenerator.incrementAndGet());
        }
        personen.put(person.getId(), person);
        return person;
    }
}
