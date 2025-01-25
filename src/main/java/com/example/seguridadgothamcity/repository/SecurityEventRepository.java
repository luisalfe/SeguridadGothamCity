package com.example.seguridadgothamcity.repository;

import com.example.seguridadgothamcity.model.SecurityEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityEventRepository extends JpaRepository<SecurityEvent, Long> {

    // Ordena los eventos por ID de forma ascendente
    @Query("SELECT e FROM SecurityEvent e ORDER BY e.id ASC")
    List<SecurityEvent> findAllOrdered();
}

