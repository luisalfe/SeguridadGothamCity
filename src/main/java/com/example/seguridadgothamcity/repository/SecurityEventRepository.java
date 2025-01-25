package com.example.seguridadgothamcity.repository;

import com.example.seguridadgothamcity.model.SecurityEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityEventRepository extends JpaRepository<SecurityEvent, Long> {
}
