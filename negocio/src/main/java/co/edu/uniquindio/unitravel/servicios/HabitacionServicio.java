package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;

import java.time.LocalDateTime;
import java.util.List;

public interface HabitacionServicio {

    Habitacion crearHabitacion(Habitacion habitacion) throws Exception;
    Habitacion actualizarHabitacion (Habitacion habitacion) throws Exception;
    Habitacion obtenerHabitacion (int codigo) throws Exception;
    void eliminarHabitacion (int codigo) throws Exception;

    List<Habitacion> obtenerHabitaciones ();

    List<Habitacion>obtenerHabitacionesDisponibles(LocalDateTime fechaInicioReserva, LocalDateTime fechaFinReserva, int codigoHotel);
}
