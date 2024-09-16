package com.apirergr.apirer.controllers;

import com.apirergr.apirer.modelos.Direccion;
import com.apirergr.apirer.servicios.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public List<Direccion> getAllDirecciones() {
        return direccionService.getAllDirecciones();
    }

    @GetMapping("/{id}")
    public Direccion getDireccionById(@PathVariable Long id) {
        return direccionService.getDireccionById(id);
    }

    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionService.saveDireccion(direccion);
    }

    @PutMapping("/{id}")
    public Direccion updateDireccion(@PathVariable Long id, @RequestBody Direccion direccion) {
        return direccionService.updateDireccion(id, direccion);
    }

    @DeleteMapping("/{id}")
    public void deleteDireccion(@PathVariable Long id) {
        direccionService.deleteDireccion(id);
    }
}
