package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

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

    @ElementCollection
    @JoinColumn(nullable = false)
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
