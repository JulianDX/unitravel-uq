package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;
import java.util.Optional;

public interface UnitravelServicio {

    List<Ciudad> listarCiudades();

    Ciudad obtenerCiudad(Integer codigo);

    List<Caracteristica> listarCaracteristicasHotel();

    List<Caracteristica> listarCaracteristicasHabitacion();

    Caracteristica obtenerCaracteristica(Integer id) throws Exception;

    Hotel obtenerHotel(Integer codigo) throws Exception;

    void crearComentario(Comentario comentario);

    Persona validarLogin (String email, String password) throws Exception;

    List<AdministradorHotel> listarAdministradoresHotel();


}
