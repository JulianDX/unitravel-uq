package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;

import java.util.List;

public interface AdministradorHotelServicio {

    Hotel crearHotel(Hotel hotel) throws Exception;

    Habitacion crearHabitacion(Habitacion h) throws Exception;

    Hotel obtenerHotel(String nombre, String direccion) throws Exception;

    Habitacion obtenerHabitacion(Integer numero) throws Exception;

    AdministradorHotel obtenerAdmin(String codigo);

    List<Ciudad> listarCiudades();

    Hotel obtenerHotel(Integer codigo) throws Exception;



}
