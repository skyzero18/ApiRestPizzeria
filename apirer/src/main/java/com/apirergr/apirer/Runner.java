package com.apirergr.apirer;
import com.apirergr.apirer.modelos.Clientes;
import com.apirergr.apirer.modelos.Direccion;
import com.apirergr.apirer.modelos.Pizzeria;
import com.apirergr.apirer.modelos.Vendedores;
import com.apirergr.apirer.repositorios.ClienteRepo;
import com.apirergr.apirer.repositorios.DireccionRepo;
import com.apirergr.apirer.repositorios.PizzeriaRepo;
import com.apirergr.apirer.repositorios.VendedoresRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {
    private final ClienteRepo clienteRepo;
    private final VendedoresRepo vendedoresRepo;
    private final PizzeriaRepo pizzeriaRepo;
    private final DireccionRepo direccionRepo;
    public Runner(ClienteRepo clienteRepo, VendedoresRepo vendedoresRepo, PizzeriaRepo pizzeriaRepo, DireccionRepo direccionRepo) {
        this.clienteRepo = clienteRepo;
        this.vendedoresRepo = vendedoresRepo;
        this.pizzeriaRepo = pizzeriaRepo;
        this.direccionRepo = direccionRepo;

    }

    @Override
    public void run(String... args) {
        Clientes cliente1 = new Clientes("Gabriel", "Rodriguez", "2634896357","47269448");
        Vendedores vendedores1= new Vendedores("luciano","47269448","jofre","si");
        Direccion direccion1= new Direccion("25Mayo","42","mendoza","5570");
        Pizzeria pizzeria1= new Pizzeria("mauro","mauricio","1987");
        clienteRepo.saveAll(Set.of(cliente1));
        vendedoresRepo.saveAll(Set.of(vendedores1));
        pizzeriaRepo.saveAll(Set.of(pizzeria1));
        direccionRepo.saveAll(Set.of(direccion1));

    }
}
