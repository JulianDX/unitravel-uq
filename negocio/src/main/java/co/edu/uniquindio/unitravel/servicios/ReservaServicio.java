package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;

import java.util.List;

public interface ReservaServicio {


    Reserva registrarReserva (Reserva reserva) throws Exception;

    Reserva actualizarReserva (Reserva reserva) throws Exception;

    Reserva obtenerReserva (int codigo) throws Exception;

    void eliminarReserva (int codigo) throws  Exception;

    List<Reserva> obtenerReservas();

    List<Reserva> listarReservasCliente(String cedula) throws Exception;

    List<Hotel> obtenerHotelReserva(Integer idReserva) throws Exception;
}
