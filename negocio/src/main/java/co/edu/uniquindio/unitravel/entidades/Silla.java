package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 10)
    private String posicion;

    @PositiveOrZero
    @Column(nullable = false)
    private Double precio;

    @OneToMany(mappedBy = "silla")
    private List<ReservaSilla> reservaSillas;

    @ManyToOne
    private Vuelo vueloSilla;


}
