package com.apirergr.apirer.repositorios;
import com.apirergr.apirer.modelos.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepo extends JpaRepository<Direccion, Long> {
}
