package com.apirergr.apirer.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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

    @OneToMany(targetEntity = Direccion.class, fetch = FetchType.LAZY)
    private List<Direccion> direcciones;
    @JsonIgnore

    @ManyToMany (targetEntity = Vendedores.class, fetch = FetchType.LAZY)
    @JoinTable(name = "vendedor_id")
    private List<Vendedores> vendedor;
    @JsonIgnore

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
