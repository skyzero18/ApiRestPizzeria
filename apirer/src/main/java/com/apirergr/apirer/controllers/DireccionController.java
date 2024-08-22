package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Direccion;
import com.apirergr.apirer.repositorios.DireccionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {
    @Autowired
    private DireccionRepo direccionRepo;

    @GetMapping
    public List<Direccion> obtenerTodasDireccion() {
        return direccionRepo.findAll();
    }

    @GetMapping("/{id}")
    public Direccion obtenerDireccionPorId(@PathVariable Long id) {
        return direccionRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Direccion crearDireccion(@RequestBody Direccion direccion) {
        return direccionRepo.save(direccion);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDireccion(@PathVariable Long id) {
        if (direccionRepo.existsById(id)) {
            direccionRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}