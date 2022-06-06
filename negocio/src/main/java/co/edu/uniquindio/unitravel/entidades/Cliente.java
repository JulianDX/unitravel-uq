package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {

    @ToString.Include
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    private List<String> telefono;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Comentario> comentarios;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Queja> quejas;

    @ManyToOne
    private Ciudad ciudad;

    public Cliente(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}
