package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Pizzeria;
import com.apirergr.apirer.servicios.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {

    @Autowired
    private PizzeriaService pizzeriaService;

    @GetMapping
    public List<Pizzeria> getAllPizzeria(){
        return pizzeriaService.getAllPizzerias();
    }

    @GetMapping("/{id}")
    public Pizzeria getPizzeriaById(@PathVariable Long id) {
        return pizzeriaService.getPizzeriaById(id);
    }

    @PostMapping
    public Pizzeria createPizzeria(@RequestBody Pizzeria pizzeria) {
        return pizzeriaService.savePizzeria(pizzeria);
    }

    @PutMapping("/{id}")
    public Pizzeria updatePizzeria(@PathVariable Long id, @RequestBody Pizzeria pizzeria) {
        return pizzeriaService.updatePizzeria(id, pizzeria);
    }

    @DeleteMapping("/{id}")
    public void deletePizzeria(@PathVariable Long id) {
        pizzeriaService.deletePizzeria(id);
    }
}
