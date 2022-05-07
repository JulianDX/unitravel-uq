package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Foto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, unique = true, length = 100)
    private String url;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Hotel habitacion;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Hotel hotel;

}
