package com.example.demo.controller;

import com.example.demo.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeMvcController {
    @Autowired
    private WelcomeService welcomeService;

    @GetMapping(produces = "text/plain")
    public String greeting1(String name, Model model) {
        model.addAttribute("welcome", welcomeService.greetingMessage1(name));
        return "welcome-page";
    }

    @GetMapping(value = "/event", produces = "text/plain")
    public String greeting2(String name, Model model) {
        model.addAttribute("welcomeToEvent", welcomeService.greetingMessage2(name));
        return "event-page";
    }
}