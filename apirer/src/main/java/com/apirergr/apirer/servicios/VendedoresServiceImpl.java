package com.apirergr.apirer.servicios;
import com.apirergr.apirer.modelos.Vendedores;
import com.apirergr.apirer.repositorios.VendedoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendedoresServiceImpl implements VendedoresService {

    @Autowired
    private VendedoresRepo vendedoresRepo;

    @Override
    public List<Vendedores> getAllVendedores() {
        return vendedoresRepo.findAll();
    }

    @Override
    public Vendedores getVendedorById(Long id) {
        Optional<Vendedores> vendedor = vendedoresRepo.findById(id);
        if (vendedor.isPresent()) {
            return vendedor.get();
        }else {
            throw new RuntimeException("Vendedor no encontrado para el id " + id);
        }
    }

    @Override
    public Vendedores saveVendedor(Vendedores vendedor) {
        return vendedoresRepo.save(vendedor);
    }

    @Override
    public Vendedores updateVendedor(Long id, Vendedores vendedor) {
        Vendedores existingVendedor = getVendedorById(id);

        existingVendedor.setNombre(vendedor.getNombre());
        existingVendedor.setApellido(vendedor.getApellido());
        existingVendedor.setExperiencia(vendedor.getExperiencia());
        existingVendedor.setDNI(vendedor.getDNI());

        existingVendedor.setClientes(vendedor.getClientes());
        existingVendedor.setPizzeria(vendedor.getPizzeria());
        return vendedoresRepo.save(vendedor);
    }

    @Override
    public void deleteVendedor(Long id) {
        vendedoresRepo.deleteById(id);
    }
}
