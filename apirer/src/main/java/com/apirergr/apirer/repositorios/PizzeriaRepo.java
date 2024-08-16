package com.apirergr.apirer.repositorios;
import com.apirergr.apirer.modelos.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzeriaRepo extends JpaRepository<Pizzeria, Long> {
}
