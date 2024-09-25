package com.apirergr.apirer.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "direcciongn", sequenceName = "direccionsq", allocationSize = 1)
    private Long id;

    @Column(name = "calle", nullable = false)
    private String calle;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

    @ManyToOne(targetEntity = Clientes.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_id")
    @JsonIgnore
    private Clientes clientes;

    @OneToOne(mappedBy = "direccion")
    @JsonIgnore
    private Pizzeria pizzeria;

    public Direccion(String calle,String numero, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.numero=numero;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}
