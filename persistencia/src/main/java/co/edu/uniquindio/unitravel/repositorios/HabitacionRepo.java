package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion,Integer> {

    @Query("select h from Habitacion h where h.precio >= :precio1 and h.precio <= :precio2")
    List<Habitacion> listarHabitacionesPorRangoDePrecio(Double precio1, Double precio2);

    @Query("select h from Habitacion h where h.capacidad = :capacidad")
    List<Habitacion> listarHabitacionesPorCapacidad(Integer capacidad);

}
