package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false, length = 50)
    private String aerolinea;

    @OneToMany(mappedBy = "vueloSilla")
    private List<Silla> sillas;

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;
}
