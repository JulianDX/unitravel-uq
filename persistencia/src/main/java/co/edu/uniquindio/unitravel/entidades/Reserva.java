package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @PositiveOrZero
    @Column(nullable = false)
    private int cantidadPersonas;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaSilla> reservasillas;

    @OneToMany(mappedBy = "reserva")
    private List<ReservaHabitacion> reservaHabitaciones;

}
