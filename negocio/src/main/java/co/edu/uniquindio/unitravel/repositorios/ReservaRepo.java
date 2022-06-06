package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

    @Query("select count(r) from Reserva  r join r.habitaciones hb where hb.hotel.codigo = ?1 " +
            "and r.fechaInicio > current_date")
    int numeroReservasHotel(int codigoHotel);

    @Query("select sum(res.precioTotal) from Reserva res where res.cliente.cedula = ?1")
    double calcularReservasTotalUsuario(String cedulaCliente);

    @Query("select res from Reserva res where res.cliente.cedula = :cedula ")
    List<Reserva>listaReservasCliente(String cedula);

    @Query("select res from Reserva  res where res.estado = 'A'")
    List<Reserva> obtenerListaReservas();

    @Query("select h from Reserva r join r.habitaciones hb join  hb.hotel h where r.codigo = ?1")
    List<Hotel> hotelReserva(Integer idReserva);
}
