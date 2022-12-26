package com.mads.springsecuritymads.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }

    @PreAuthorize("hasAuthority('administrador')")
    @GetMapping("/msgSecreto")
    public String MensajeSecreto(){
        return "Mensaje Secreto";
    }

}
