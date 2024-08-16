package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Pizzeria;
import com.apirergr.apirer.repositorios.PizzeriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {
    @Autowired
    private PizzeriaRepo pizzeriaRepo;

    @GetMapping
    public List<Pizzeria> obtenerTodasPizzeria() {
        return pizzeriaRepo.findAll();
    }

    @GetMapping("/{id}")
    public Pizzeria obtenerPizzeriaPorId(@PathVariable Long id) {
        return pizzeriaRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Pizzeria crearPizzeria(@RequestBody Pizzeria pizzeria) {
        return pizzeriaRepo.save(pizzeria);
    }

}
