package com.apirergr.apirer.controllers;
import com.apirergr.apirer.modelos.Clientes;
import com.apirergr.apirer.servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Clientes> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Clientes getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public Clientes createCliente(@RequestBody Clientes cliente) {
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public Clientes updateCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}