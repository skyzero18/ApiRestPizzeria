package com.apirergr.apirer.modelos;

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

    public Vendedores(String nombre, String DNI,String apellido, String experiencia) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.apellido = apellido;
        this.experiencia = experiencia;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendedorgn")
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
    private Pizzeria pizzeria;


    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    private List<Clientes> clientes;

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