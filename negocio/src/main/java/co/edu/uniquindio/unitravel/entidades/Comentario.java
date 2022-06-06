package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Lob
    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private int calificacion;

    @Column(nullable = false)
    private LocalDate fechaCalifiacion;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Hotel hotel;

    public Comentario(String comentario, int calificacion, Cliente cliente, Hotel hotel) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fechaCalifiacion = LocalDate.now();
        this.cliente = cliente;
        this.hotel = hotel;
    }
}
