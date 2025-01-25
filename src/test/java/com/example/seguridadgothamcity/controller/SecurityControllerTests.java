package com.example.seguridadgothamcity.controller;

import com.example.seguridadgothamcity.model.SecurityEvent;
import com.example.seguridadgothamcity.service.SecurityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SecurityService securityService;

    @Test
    @DirtiesContext
    public void testCreateEvent() throws Exception {
        String eventJson = """
            {
                "description": "Test Event",
                "timestamp": "2025-01-25T10:00:00"
            }
        """;

        mockMvc.perform(post("/security/event")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(eventJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Test Event"))
                .andExpect(jsonPath("$.timestamp").value("2025-01-25T10:00:00"));
    }

    @Test
    @DirtiesContext
    public void testGetAllEvents() throws Exception {
        SecurityEvent event1 = new SecurityEvent();
        event1.setDescription("Test Event 1");
        event1.setTimestamp("2025-01-25T10:00:00");
        securityService.saveEvent(event1);

        SecurityEvent event2 = new SecurityEvent();
        event2.setDescription("Test Event 2");
        event2.setTimestamp("2025-01-25T10:30:00");
        securityService.saveEvent(event2);

        mockMvc.perform(get("/security/events")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("Test Event 1"))
                .andExpect(jsonPath("$[1].description").value("Test Event 2"));
    }

    @Test
    @DirtiesContext
    public void testGetAllEventsEmpty() throws Exception {
        mockMvc.perform(get("/security/events")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}


