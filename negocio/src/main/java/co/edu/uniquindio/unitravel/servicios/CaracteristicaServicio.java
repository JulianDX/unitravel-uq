package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;

import java.util.List;

public interface CaracteristicaServicio {

    Caracteristica registrarCaracteristica(Caracteristica caracteristica) throws Exception;
    Caracteristica actualizarCaracteristica(Caracteristica caracteristica);
    Caracteristica obtenerCaracteristica(int codigo) throws Exception;
    void eliminarCaracteristica(int codigo) throws Exception;

    List<Caracteristica> obtenerCaracteristicas();

    List<Caracteristica> obtenerCaracteristicasHoteles();

    List<Caracteristica> obtenerCaracteristicasHabitaciones();

}
