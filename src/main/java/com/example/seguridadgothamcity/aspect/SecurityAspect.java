package com.example.seguridadgothamcity.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    @Before("execution(* com.example.seguridadgothamcity.controller.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("Interceptando llamada a un método del controlador de seguridad.");
    }
}

