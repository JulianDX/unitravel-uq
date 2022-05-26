package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio{

    private ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo){
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Cliente registrarCliente(Cliente c) throws Exception {

        Cliente buscarCedula = obtenerCliente(c.getCedula());

        if(buscarCedula!=null){
            throw new Exception("Ya hay un usuario en el sistema con la cédula: "+c.getCedula());
        }

        Cliente buscarCorreo = obtenerClienteEmail(c.getEmail());

        if(buscarCorreo!=null){
            throw new Exception("Ya hay un usuario en el sistema con el correo: "+c.getEmail());
        }

        return clienteRepo.save(c);
    }

    @Override
    public Cliente actualizarCliente(Cliente c) throws Exception {

        Cliente cliente = obtenerCliente(c.getCedula());

        if(cliente==null){
            throw new Exception("El usuario con cédula: "+c.getCedula()+" no existe");
        }

        return clienteRepo.save(c);
    }

    @Override
    public Cliente obtenerCliente(String cedula){
        return clienteRepo.findById(cedula).orElse(null);
    }

    @Override
    public Cliente validarLogin(String email, String password) throws Exception {

        Optional<Cliente> cliente = clienteRepo.findByEmailAndPassword(email, password);

        if(cliente.isEmpty()){
            throw new Exception("Email o contraseña incorrectos");
        }

        return cliente.get();
    }

    public Cliente obtenerClienteEmail(String correo){
        return clienteRepo.findByEmail(correo).orElse(null);
    }

    @Override
    public void eliminarCliente(String cedula) throws Exception {
        Cliente cliente = obtenerCliente(cedula);

        if(cliente==null){
            throw new Exception("El usuario con cédula: "+cedula+" no existe");
        }

        clienteRepo.delete(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Comentario crearComentario(String comentario) {
        return null;
    }

    @Override
    public Reserva hacerReserva() {
        return null;
    }

    @Override
    public List<Hotel> buscarHotelNombre(String nombre) {
        return null;
    }
}
