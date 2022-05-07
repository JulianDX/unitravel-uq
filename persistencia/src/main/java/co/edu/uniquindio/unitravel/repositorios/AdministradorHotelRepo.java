package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorHotelRepo extends JpaRepository<AdministradorHotel,String> {

    @Query("select a from Administrador a where a.nombre = :nombre")
    List<AdministradorHotel> listarAdministradoresHotelPorNombre(String nombre);

    @Query("select a from Administrador a where a.email = :email and a.password = :password")
    Optional<AdministradorHotel> Autenticacion(String email, String password);

    @Query("select a from Administrador a where a.cedula = :cedula")
    Optional<AdministradorHotel>  listarAdministradoresHotelPorCedula(String cedula);

    @Override
    Page<AdministradorHotel> findAll(Pageable pageable);

}
