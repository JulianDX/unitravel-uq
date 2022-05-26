package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {

    @Query("select h from Hotel h where h.nombre like %:nombre%")
    List<Hotel> listarHotelesPorNombre(String nombre);

    @Query("select h from Hotel h where h.estrellas = :estrellas")
    List<Hotel> listarHotelesPorEstrellas(Integer estrellas);

    @Query("select h from Hotel h where h.ciudad.nombre = :ciudad")
    List<Hotel> listarHotelesPorCiudad(String ciudad);


}
