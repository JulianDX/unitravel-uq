package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

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
@ToString
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

    @JoinColumn(nullable = false)
    @ManyToOne
    private AdministradorHotel admin;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Foto> fotos;

    @OneToOne(mappedBy = "hotel")
    @ToString.Exclude
    private Descuento descuento;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Queja> quejas;

    @ManyToMany(mappedBy = "hoteles")
    private List<Caracteristica> caracteristicas;

    public Hotel(int codigo, String direccion,int estrellas, String nombre, String telefono, AdministradorHotel admin, Ciudad ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrellas = estrellas;
        this.admin = admin;
        this.ciudad = ciudad;
    }
}
