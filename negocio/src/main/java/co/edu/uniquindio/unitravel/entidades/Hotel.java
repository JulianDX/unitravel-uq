package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @Size(max = 100, message = "El nombre del hotel debe contener máximo 100 caracteres")
    @NotBlank(message = "El nombre del hotel no puede ser vacío")
    private String nombre;

    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "La direccion del hotel debe contener máximo 100 caracteres")
    @NotBlank(message = "La dirección del hotel no puede ser vacío")
    private String direccion;

    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El teléfono del hotel debe contener máximo 50 caracteres")
    @NotBlank(message = "El teléfono del hotel no puede ser vacío")
    private String telefono;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int estrellas;

    @JoinColumn(nullable = false)
    @ManyToOne
    private AdministradorHotel admin;

    @Lob
    private String descripcion;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Ciudad ciudad;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> fotos;

    @OneToOne
    @ToString.Exclude
    private Descuento descuento;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Queja> quejas;

    @ManyToMany
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Caracteristica> caracteristicas;

    public Hotel(int codigo, String direccion,int estrellas, String nombre, String telefono, AdministradorHotel admin, Ciudad ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrellas = estrellas;
        this.admin = admin;
        this.ciudad = ciudad;
    }

    public String getImagenPrincipal(){
        if(fotos!=null){
            if(!fotos.isEmpty()){
                return fotos.get(0);
            }
        }
        return "default.png";
    }

}
