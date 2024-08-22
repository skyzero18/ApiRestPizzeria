package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Clientes;
import com.apirergr.apirer.modelos.Direccion;
import com.apirergr.apirer.modelos.Vendedores;
import com.apirergr.apirer.repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepo clienteRepo;

    @GetMapping
    public List<Clientes> obtenerTodosLosClientes() {
        return clienteRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> obtenerClientePorId(@PathVariable Long id) {
        Optional<Clientes> cliente = clienteRepo.findById(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public List<Clientes> crearClientes(@RequestBody List<Clientes> clientes) {
        return clienteRepo.saveAll(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClientes(@PathVariable Long id) {
        if (clienteRepo.existsById(id)) {
            clienteRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}