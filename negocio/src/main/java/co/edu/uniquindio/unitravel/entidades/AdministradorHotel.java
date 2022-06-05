package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorHotel extends Persona implements Serializable {

    @OneToMany(mappedBy = "admin")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Hotel> hoteles;

    public AdministradorHotel(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }

}
