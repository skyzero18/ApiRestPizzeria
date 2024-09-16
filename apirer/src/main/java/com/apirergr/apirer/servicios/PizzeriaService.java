package com.apirergr.apirer.servicios;
import com.apirergr.apirer.modelos.Pizzeria;
import java.util.List;

public interface PizzeriaService {
    List<Pizzeria> getAllPizzerias();
    Pizzeria getPizzeriaById(Long id);
    Pizzeria savePizzeria(Pizzeria pizzeria);
    Pizzeria updatePizzeria(Long id, Pizzeria pizzeria);
    void deletePizzeria(Long id);
}
