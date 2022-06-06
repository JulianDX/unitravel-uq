package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicioImpl implements ClienteServicio{

    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private CiudadRepo ciudadRepo;
    @Autowired
    private ReservaRepo reservaRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo, HotelRepo hotelRepo, CiudadRepo ciudadRepo){
        this.clienteRepo = clienteRepo;
        this.hotelRepo = hotelRepo;
        this.ciudadRepo = ciudadRepo;
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

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        c.setPassword(passwordEncryptor.encryptPassword(c.getPassword()));

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



    public Cliente obtenerClienteEmail(String correo){
        return (Cliente) clienteRepo.findByEmail(correo);
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
    public List<Hotel> buscarHotelNombre(String nombre){
        return hotelRepo.buscarHotelNombre(nombre);
    }

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepo.findAll();
    }

    @Override
    public Reserva hacerReserva(Reserva reserva, List<Habitacion> habitaciones, Vuelo vuelo) throws Exception {
        return null;
    }


    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return ciudadRepo.findById(codigo).orElseThrow(()-> new Exception("El código no existe"));
    }


}
