package com.apirergr.apirer.servicios;
import com.apirergr.apirer.modelos.Pizzeria;
import com.apirergr.apirer.repositorios.PizzeriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {

    @Autowired
    private PizzeriaRepo pizzeriaRepo;

    @Override
    public List<Pizzeria> getAllPizzerias() {
        return pizzeriaRepo.findAll();
    }

    @Override
    public Pizzeria getPizzeriaById(Long id) {
        Optional<Pizzeria> pizzeria = pizzeriaRepo.findById(id);
        if (pizzeria.isPresent()) {
            return pizzeria.get();
        } else {
            throw new RuntimeException("no se encontro la pizzeria " + id);
        }
    }

    @Override
    public Pizzeria savePizzeria(Pizzeria pizzeria) {
        return pizzeriaRepo.save(pizzeria);
    }

    @Override
    public Pizzeria updatePizzeria(Long id, Pizzeria pizzeria) {
        Pizzeria existingPizzeria = getPizzeriaById(id);

        existingPizzeria.setNombre(pizzeria.getNombre());
        existingPizzeria.setPropietario(pizzeria.getPropietario());
        existingPizzeria.setFundacion(pizzeria.getFundacion());

        existingPizzeria.setDireccion(pizzeria.getDireccion());
        existingPizzeria.setVendedores(pizzeria.getVendedores());

        return pizzeriaRepo.save(existingPizzeria);
    }

    @Override
    public void deletePizzeria(Long id) {
        pizzeriaRepo.deleteById(id);
    }
}
