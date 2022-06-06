package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 30)
    @Size(max = 30,message = "La cedula debe contener menos de 30 caracteres")
    private String cedula;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "El nombre no puede ser vacío")
    @Size(max = 100,message = "El nombre debe contener máximo 100 caracteres")
    private String nombre;

    @Email
    @Column(nullable = false, length = 100)
    @Size(max = 100,message = "El correo debe contener máximo 100 caracteres")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "La contraseña no puede ser vacía")
    private String password;

}
