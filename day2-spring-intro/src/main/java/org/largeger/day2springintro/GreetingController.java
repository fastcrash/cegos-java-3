package org.largeger.day2springintro;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private String name = "Welt";

    @GetMapping
    public GreetingDTO greet() {
        return new GreetingDTO("Hallo", name);
    }

    @PostMapping
    public GreetingDTO changeName(@RequestBody GreetingDTO greeting) {
        this.name = greeting.getName();
        return new GreetingDTO("Hi", this.name);
    }
}
