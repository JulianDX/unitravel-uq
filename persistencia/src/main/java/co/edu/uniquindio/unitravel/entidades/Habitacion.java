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
@ToString
public class Habitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private int capacidad;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "habitacion")
    @ToString.Exclude
    private List<Foto> fotos;

    @OneToMany(mappedBy = "habitacion")
    @ToString.Exclude
    private List<ReservaHabitacion> habitaciones;

    @ManyToMany(mappedBy = "habitacion")
    @ToString.Exclude
    private List<Caracteristica> caracteristicas;

    @ManyToMany
    @ToString.Exclude
    private List<Cama> cama;

}
