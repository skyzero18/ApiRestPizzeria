package com.apirergr.apirer.servicios;

import com.apirergr.apirer.modelos.Vendedores;
import java.util.List;
import java.util.Optional;

public interface VendedoresService {
    List<Vendedores> getAllVendedores();
    Vendedores getVendedorById(Long id);
    Vendedores saveVendedor(Vendedores vendedor);
    Vendedores updateVendedor(Long id, Vendedores vendedor);
    void deleteVendedor(Long id);
}
