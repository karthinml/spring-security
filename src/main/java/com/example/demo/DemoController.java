package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/greet")
    public String greet(HttpServletRequest request) {
        return "Welcome to Security Demo " + request.getSession().getId();
    }
}
