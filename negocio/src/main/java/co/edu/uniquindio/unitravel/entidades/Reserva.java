package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @PositiveOrZero
    @Column(nullable = false)
    private Double precioTotal;

    @Column(nullable = false, length = 50)
    private String estado;

    @Positive
    @Column(nullable = false)
    private int cantidadPersonas;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaSilla> reservasillas;


    @OneToMany(mappedBy = "reserva")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitaciones;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToOne
    private MetodoPago metodoPago;

    public Reserva(int codigo, LocalDateTime fechaReserva, LocalDate fechaInicio, LocalDate fechaFin, Double precioTotal) {
        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
    }
}
