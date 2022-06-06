package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Hotel;

import java.util.List;

public interface HotelServicio {


    Hotel registrarHotel (Hotel hotel) throws Exception;

    Hotel actualizarHotel (Hotel hotel) throws Exception;

    Hotel obtenerHotel (int codigo) throws Exception;


    void eliminarHotel (int codigo) throws  Exception;


    List<Hotel> obtenerHoteles();

    List<Hotel> obtenerHotelesPorDestino(String nombreCiudad);

    List<Hotel> obtenerHotelPorNombre(String nombre);

    List<Caracteristica> obtenerCaracteristicasHotel(Integer codigo);
}