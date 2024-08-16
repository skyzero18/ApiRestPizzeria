package com.apirergr.apirer.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "clientesgn", sequenceName = "clientessq", allocationSize = 1)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "celular", nullable = false)
    private String celular;

    @Column(name = "DNI", nullable = false)
    private String DNI;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedores vendedor;


    public Clientes(String nombre, String apellido, String celular, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", celular='" + celular + '\'' +
                ", DNI=" + DNI +
                ", vendedor=" + vendedor +
                '}';
    }
}
