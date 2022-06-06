
package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,String> {

    @Query("select a from Administrador a where a.nombre = :nombre")
    List<Administrador> listarAdministradoresPorNombre(String nombre);

    @Query("select a from Administrador a where a.email = :email and a.password = :password")
    Optional<Administrador> Autenticacion(String email, String password);

    @Query("select a from Administrador a where a.cedula = :cedula")
    Optional<Administrador>  listarAdministradoresPorCedula(String cedula);

    @Override
    Page<Administrador> findAll(Pageable pageable);

    Optional<Persona> findByEmail(String correo);

}