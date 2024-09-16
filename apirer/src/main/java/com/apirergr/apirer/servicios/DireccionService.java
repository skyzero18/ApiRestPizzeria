package com.apirergr.apirer.servicios;
import com.apirergr.apirer.modelos.Direccion;
import java.util.List;

public interface DireccionService {
    List<Direccion> getAllDirecciones();
    Direccion getDireccionById(Long id);
    Direccion saveDireccion(Direccion direccion);
    Direccion updateDireccion(Long id, Direccion direccion);
    void deleteDireccion(Long id);
}
