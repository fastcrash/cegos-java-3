package org.largeger.day3dockerspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public List<Greeting> getGreetings() {

        return greetingService.getAllGreetings();
    }

    @PostMapping
    public String addGreeting(@RequestBody String name) {
        greetingService.addGreeting(name);
        return "Begrüßung für " + name + " hinzugefügt.";
    }
}
