package com.apirergr.apirer.modelos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "vendedores")
public class Vendedores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "vendedorgn", sequenceName = "vendedorsq", allocationSize = 1)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "DNI", nullable = false)
    private String DNI;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "experiencia", nullable = false)
    private String experiencia;

    @ManyToOne
    @JoinColumn(name = "pizzeria_id")
    @JsonIgnore
    private Pizzeria pizzeria;

    @ManyToMany (targetEntity = Clientes.class, fetch = FetchType.LAZY)
    private List<Clientes> clientes;

    public Vendedores(String nombre, String DNI,String apellido, String experiencia) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.apellido = apellido;
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Vendedores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", apellido='" + apellido + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }
}