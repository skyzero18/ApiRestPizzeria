package com.apirergr.apirer.servicios;

import com.apirergr.apirer.modelos.Clientes;

import java.util.List;

public interface ClienteService {
    List<Clientes> getAllClientes();
    Clientes getClienteById(Long id);
    Clientes saveCliente(Clientes cliente);
    Clientes updateCliente(Long id, Clientes cliente);
    void deleteCliente(Long id);
}
