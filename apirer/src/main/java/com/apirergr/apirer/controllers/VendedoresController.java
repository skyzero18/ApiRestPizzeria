package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Vendedores;
import com.apirergr.apirer.servicios.VendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendedoresController {

    @Autowired
    private VendedoresService vendedoresService;

    @GetMapping
    public List<Vendedores> getAllVendedores() {
        return vendedoresService.getAllVendedores();
    }

    @GetMapping("/{id}")
    public Vendedores getVendedores(@PathVariable Long id) {
        return vendedoresService.getVendedorById(id);
    }

    @PostMapping
    public Vendedores createVendedor(@RequestBody Vendedores vendedor) {
        return vendedoresService.saveVendedor(vendedor);
    }

    @PutMapping("/{id}")
    public Vendedores updateVendedor(@PathVariable Long id, @RequestBody Vendedores vendedor) {
        return vendedoresService.updateVendedor(id, vendedor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendedor(@PathVariable Long id) {
        vendedoresService.deleteVendedor(id);
    }
}
