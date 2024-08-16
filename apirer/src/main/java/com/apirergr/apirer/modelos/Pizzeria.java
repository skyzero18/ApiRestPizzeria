package com.apirergr.apirer.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "pizzeria")
public class Pizzeria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "pizzeriaagn", sequenceName = "pizzeriasq", allocationSize = 1)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "propietario", nullable = false)
    private String propietario;

    @Column(name = "fundacion", nullable = false)
    private String fundacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;



    public Pizzeria(String nombre, String propietario, String fundacion) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.fundacion = fundacion;
    }

    @Override
    public String toString() {
        return "pizzeria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", propietario='" + propietario + '\'' +
                ", fundacion='" + fundacion + '\'' +
                '}';
    }
}
