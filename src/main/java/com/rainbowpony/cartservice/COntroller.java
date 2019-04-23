package com.rainbowpony.cartservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class COntroller {
    @GetMapping("/")
    String asdf() {
        return "Hello";
    }
}
