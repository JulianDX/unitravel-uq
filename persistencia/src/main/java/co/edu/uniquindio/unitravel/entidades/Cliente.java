package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true,onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefonos;

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
