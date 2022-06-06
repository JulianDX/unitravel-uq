package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface ClienteServicio {

    Cliente registrarCliente(Cliente c) throws Exception;

    Cliente actualizarCliente(Cliente c) throws Exception;

    Cliente obtenerCliente(String cedula);

    void eliminarCliente(String cedula) throws Exception;

    List<Cliente> listarClientes();

    Comentario crearComentario(String comentario);

    Reserva hacerReserva();

    List<Hotel> buscarHotelNombre(String nombre);

    List<Hotel> listarHoteles();

    Reserva hacerReserva(Reserva reserva, List<Habitacion> habitaciones, Vuelo vuelo) throws Exception;

    Ciudad obtenerCiudad(Integer codigo) throws Exception;

    Persona obtenerClientePorCorreo(String pass_reset);

    List<Hotel> ListarHotelsPorNumeroEstrellas(Integer numero) throws Exception;
}
