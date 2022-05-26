package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;

import java.util.List;

public interface ClienteServicio {

    Cliente registrarCliente(Cliente c) throws Exception;

    Cliente actualizarCliente(Cliente c) throws Exception;

    Cliente obtenerCliente(String cedula);

    Cliente validarLogin (String email, String password) throws Exception;

    void eliminarCliente(String cedula) throws Exception;

    List<Cliente> listarClientes();

    Comentario crearComentario(String comentario);

    Reserva hacerReserva();

    List<Hotel> buscarHotelNombre(String nombre);

}
