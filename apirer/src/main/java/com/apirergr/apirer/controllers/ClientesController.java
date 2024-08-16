package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Clientes;
import com.apirergr.apirer.repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public Clientes obtenerClientePorId(@PathVariable Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Clientes crearCliente(@RequestBody Clientes cliente) {
        return clienteRepo.save(cliente);
    }

}
