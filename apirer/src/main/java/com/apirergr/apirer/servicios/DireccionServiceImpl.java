package com.apirergr.apirer.servicios;
import com.apirergr.apirer.modelos.Direccion;
import com.apirergr.apirer.repositorios.DireccionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepo direccionRepo;

    @Override
    public List<Direccion> getAllDirecciones() {
        return direccionRepo.findAll();
    }

    @Override
    public Direccion getDireccionById(Long id) {
        Optional<Direccion> direccion = direccionRepo.findById(id);
        if (direccion.isPresent()) {
            return direccion.get();
        } else {
            throw new RuntimeException("Dirección no encontrada para el id: " + id);
        }
    }

    @Override
    public Direccion saveDireccion(Direccion direccion) {
        return direccionRepo.save(direccion);
    }

    @Override
    public Direccion updateDireccion(Long id, Direccion direccion) {
        Direccion existingDireccion = getDireccionById(id);

        existingDireccion.setCalle(direccion.getCalle());
        existingDireccion.setNumero(direccion.getNumero());
        existingDireccion.setCiudad(direccion.getCiudad());
        existingDireccion.setCodigoPostal(direccion.getCodigoPostal());


        existingDireccion.setClientes(direccion.getClientes());

        return direccionRepo.save(existingDireccion);
    }

    @Override
    public void deleteDireccion(Long id) {
        direccionRepo.deleteById(id);
    }
}
