package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Vendedores;
import com.apirergr.apirer.repositorios.VendedoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public Vendedores obtenerVendedorPorId(@PathVariable Long id) {
        return vendedoresRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Vendedores crearVendedor(@RequestBody Vendedores vendedor) {
        return vendedoresRepo.save(vendedor);
    }

    @PutMapping("/{id}")
    public Vendedores actualizarVendedor(@PathVariable Long id, @RequestBody Vendedores vendedorActualizado) {
        return vendedoresRepo.findById(id)
                .map(vendedor -> {
                    vendedor.setNombre(vendedorActualizado.getNombre());
                    return vendedoresRepo.save(vendedor);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarVendedor(@PathVariable Long id) {
        vendedoresRepo.deleteById(id);
    }

}
