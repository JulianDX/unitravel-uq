package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
    @Min(1)
    @NotNull (message = "El número no puede ir vacío")
    private int numero;

    @Column(nullable = false)
    @NotNull (message = "El precio no puede ir vacío")
    @Positive(message = "El precio debe ser positivo")
    private Double precio;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int capacidad;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Hotel hotel;

    @Column(length = 1, nullable = true, columnDefinition = "varchar(1) default 'A'")
    private String estado;


    @ToString.Exclude
    @ManyToMany(mappedBy = "habitaciones")
    private List<Reserva> reservas;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> fotos;



    @OneToMany(mappedBy = "habitacion")
    @ToString.Exclude
    private List<ReservaHabitacion> habitaciones;

    @ManyToMany
    @ToString.Exclude
    List<Caracteristica> caracteristicas;

    @ManyToMany
    @ToString.Exclude
    private List<Cama> camas;

    public Habitacion(Double precio, int capacidad, Hotel hotel, String estado) {
        this.precio = precio;
        this.capacidad = capacidad;
        this.hotel = hotel;
        this.estado = estado;
    }

    public String getImagenPrincipal(){
        if(fotos!=null){
            if(!fotos.isEmpty()){
                return fotos.get(0);
            }
        }
        return "default_hab.png";
    }

    public String formatearDinero(){
        Locale locale = new Locale("es","CO");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(precio);
    }

}
