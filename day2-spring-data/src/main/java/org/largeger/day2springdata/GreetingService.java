package org.largeger.day2springdata;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
//public class GreetingService {
//
//    private final List<Greeting> greetings = new ArrayList<>();
//
//    public List<Greeting> getAllGreetings() {
//        return greetings;
//    }
//
//    public void addGreeting(String name) {
//        String message = "Hallo, " + name + "!";
//        greetings.add(new Greeting(name, message));
//    }
//}

@Service
public class GreetingService {

    private final GreetingRepository repository;

    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }

    public void addGreeting(String name) {
        String message = "Hallo, " + name + "!";
        repository.save(new Greeting(name, message));
    }
}
