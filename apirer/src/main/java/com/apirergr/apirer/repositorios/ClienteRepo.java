package com.apirergr.apirer.repositorios;
import com.apirergr.apirer.modelos.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Clientes, Long> {

}
