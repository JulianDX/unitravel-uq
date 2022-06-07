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
public class Ciudad implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "ciudadOrigen")
    @ToString.Exclude
    private List<Vuelo> vuelosorigen;

    @OneToMany(mappedBy = "ciudadDestino")
    @ToString.Exclude
    private List<Vuelo> vuelosdestino;

    @Setter @Getter
    @Column(nullable = false)
    private String urlImagen;

    public Ciudad(String nombre, String urlImagen) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }


}
