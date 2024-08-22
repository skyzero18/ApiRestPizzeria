package com.apirergr.apirer.controllers;

import com.apirergr.apirer.modelos.Vendedores;
import com.apirergr.apirer.repositorios.VendedoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendedores")
public class VendedoresController {

    @Autowired
    private VendedoresRepo vendedoresRepo;

    @GetMapping
    public List<Vendedores> obtenerTodosLosVendedores() {
        return vendedoresRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedores> obtenerVendedorPorId(@PathVariable Long id) {
        Optional<Vendedores> vendedor = vendedoresRepo.findById(id);
        return vendedor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vendedores crearVendedor(@RequestBody Vendedores vendedor) {
        return vendedoresRepo.save(vendedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedores> actualizarVendedor(@PathVariable Long id, @RequestBody Vendedores vendedorActualizado) {
        return vendedoresRepo.findById(id)
                .map(vendedor -> {
                    vendedor.setNombre(vendedorActualizado.getNombre());
                    vendedor.setDNI(vendedorActualizado.getDNI());
                    vendedor.setApellido(vendedorActualizado.getApellido());
                    vendedor.setExperiencia(vendedorActualizado.getExperiencia());
                    return ResponseEntity.ok(vendedoresRepo.save(vendedor));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVendedor(@PathVariable Long id) {
        if (vendedoresRepo.existsById(id)) {
            vendedoresRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
