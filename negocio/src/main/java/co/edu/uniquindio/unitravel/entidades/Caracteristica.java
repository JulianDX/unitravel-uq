package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(nullable = false, length = 2)
    private String tipo;

    @ToString.Exclude
    @ManyToMany(mappedBy = "caracteristicas")
    private List<Hotel> hoteles;

    @ToString.Exclude
    @ManyToMany(mappedBy = "caracteristicas")
    private List<Habitacion> habitaciones;

}
