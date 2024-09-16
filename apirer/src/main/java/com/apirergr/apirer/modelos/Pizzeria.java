package com.apirergr.apirer.modelos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

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

    @OneToOne(targetEntity = Direccion.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @OneToMany (mappedBy = "pizzeria", targetEntity = Vendedores.class, fetch = FetchType.LAZY)
    private List<Vendedores> vendedores;

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
