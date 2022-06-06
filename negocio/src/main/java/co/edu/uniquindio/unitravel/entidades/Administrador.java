package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {
    public Administrador(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}
