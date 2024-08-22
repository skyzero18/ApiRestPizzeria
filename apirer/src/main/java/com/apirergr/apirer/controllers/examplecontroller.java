package com.apirergr.apirer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class examplecontroller {
    @GetMapping("/name")
    public String hola(){
        return "hola";
    }

}
