package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String direccion;

    @Column(length = 50, nullable = false)
    private String telefono;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private int estrellas;

    @ManyToOne
    private AdministradorHotel admin;

    @OneToMany(mappedBy = "hotel")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "hotel")
    private List<Foto> fotos;

    @OneToMany(mappedBy = "hotel")
    private List<Descuento> descuentos;

    @OneToMany(mappedBy = "hotel")
    private List<Queja> quejas;

    @ManyToMany(mappedBy = "hoteles")
    private List<Caracteristica> caracteristicas;

}
