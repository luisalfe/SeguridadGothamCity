package com.example.seguridadgothamcity.controller;

import com.example.seguridadgothamcity.model.SecurityEvent;
import com.example.seguridadgothamcity.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private SecurityService service;

    @PostMapping("/event")
    public SecurityEvent createEvent(@RequestBody SecurityEvent event) {
        return service.saveEvent(event);
    }

    @GetMapping("/events")
    public Iterable<SecurityEvent> getEvents() {
        return service.getAllEvents();
    }
}

