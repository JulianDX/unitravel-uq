package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private int capacidad;

    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "habitacion")
    private List<Foto> fotos;

    @OneToMany(mappedBy = "habitacion")
    private List<ReservaHabitacion> habitaciones;

    @ManyToMany(mappedBy = "habitacion")
    private List<Caracteristica> caracteristicas;

}
