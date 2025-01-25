package com.example.seguridadgothamcity.service;

import com.example.seguridadgothamcity.model.SecurityEvent;
import com.example.seguridadgothamcity.repository.SecurityEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    private SecurityEventRepository repository;

    public SecurityEvent saveEvent(SecurityEvent event) {
        return repository.save(event);
    }

    public Iterable<SecurityEvent> getAllEvents() {
        return repository.findAll();
    }
}

