package com.apirergr.apirer.servicios;

import com.apirergr.apirer.modelos.Clientes;
import com.apirergr.apirer.repositorios.ClienteRepo;

import com.apirergr.apirer.repositorios.VendedoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private VendedoresRepo vendedoresRepo;

    @Override
    public List<Clientes> getAllClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Clientes getClienteById(Long id) {
        Optional<Clientes> cliente = clienteRepo.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new RuntimeException("Cliente no encontrado para el id: " + id);
        }
    }

    @Override
    public Clientes saveCliente(Clientes cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Clientes updateCliente(Long id, Clientes cliente) {
        Clientes existingCliente = getClienteById(id);

        // Actualiza los campos del cliente existente con los datos del cliente actualizado
        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setApellido(cliente.getApellido());
        existingCliente.setCelular(cliente.getCelular());
        existingCliente.setDNI(cliente.getDNI());

        // Actualiza las relaciones si es necesario
        existingCliente.setDirecciones(cliente.getDirecciones());
        existingCliente.setVendedor(cliente.getVendedor());

        // Guarda el cliente actualizado en la base de datos
        return clienteRepo.save(existingCliente);
    }


    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }
}
