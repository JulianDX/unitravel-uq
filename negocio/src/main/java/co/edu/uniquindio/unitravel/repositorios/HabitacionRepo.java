package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion,Integer> {

    @Query("select h from Habitacion h where h.precio >= :precio1 and h.precio <= :precio2")
    List<Habitacion> listarHabitacionesPorRangoDePrecio(Double precio1, Double precio2);

    @Query("select h from Habitacion h where h.capacidad = :capacidad")
    List<Habitacion> listarHabitacionesPorCapacidad(Integer capacidad);

    @Query("select c from Caracteristica c join c.habitaciones hb where hb.numero = ?1")
    List<Caracteristica> obtenerCaracteristicasHabitacion(int codigoHabitacion);
    @Query("select h from Habitacion h where h.estado = 'A'")
    List<Habitacion> obtenerListaHabitaciones();

    @Query(value = "SELECT " +
            "H.* " +
            "FROM " +
            "RESERVA RES " +
            "INNER JOIN RESERVA_HABITACIONES RESH ON (RES.CODIGO = RESH.RESERVAS_CODIGO) " +
            "INNER JOIN HABITACION H ON (RESH.HABITACIONES_CODIGO = H.CODIGO) " +
            "INNER JOIN HOTEL HT ON (H.HOTEL_CODIGO = HT.CODIGO) " +
            "WHERE " +
            "H.ESTADO = 'A' " +
            "AND " +
            "RES.ESTADO = 'A' " +
            "AND HT.CODIGO = :codigoHotel " +
            "AND " +
            ":fechaFin > RES.FECHA_INICIO " +
            "AND " +
            ":fechaInicio < RES.FECHA_FIN", nativeQuery = true )
    List<Habitacion> consultarDisponibilidadHabitacion(LocalDateTime fechaInicio, LocalDateTime fechaFin, int codigoHotel);

}
