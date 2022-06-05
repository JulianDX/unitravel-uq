package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UnitravelServicioImpl implements UnitravelServicio{

    @Autowired
    CiudadRepo ciudadRepo;

    @Autowired
    CaracteristicaRepo caracteristicaRepo;

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    ComentarioRepo comentarioRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    AdministradorHotelRepo administradorHotelRepo;

    @Autowired
    AdministradorRepo administradorRepo;


    public UnitravelServicioImpl(CiudadRepo ciudadRepo, CaracteristicaRepo caracteristicaRepo, HotelRepo hotelRepo,
                                 ComentarioRepo comentarioRepo, ClienteRepo clienteRepo, AdministradorHotelRepo administradorHotelRepo
    ,AdministradorRepo administradorRepo){
        this.ciudadRepo = ciudadRepo;
        this.caracteristicaRepo = caracteristicaRepo;
        this.hotelRepo = hotelRepo;
        this.comentarioRepo = comentarioRepo;
        this.clienteRepo = clienteRepo;
        this.administradorHotelRepo = administradorHotelRepo;
        this.administradorRepo = administradorRepo;
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) {
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public Caracteristica obtenerCaracteristica(Integer id) throws Exception {
        return caracteristicaRepo.findById(id).orElseThrow(()-> new Exception("El código no existe"));
    }

    @Override
    public Hotel obtenerHotel(Integer codigo) throws Exception {
        return hotelRepo.findById(codigo).orElseThrow(()-> new Exception("El código no existe"));
    }

    @Override
    public void crearComentario(Comentario comentario) {
        comentario.setFechaCalifiacion(LocalDate.now());
        comentarioRepo.save(comentario);
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel() {
        return caracteristicaRepo.findAllByTipo("1");
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion() {
        return caracteristicaRepo.findAllByTipo("2");
    }

    @Override
    public Persona validarLogin(String email, String password) throws Exception {

        try{
            StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
            Persona usuario = clienteRepo.findByEmail(email);

            if(usuario==null){
                usuario = administradorRepo.findByEmail(email).orElse(null);
            }else{
                if(!strongPasswordEncryptor.checkPassword(password,usuario.getPassword())){
                    throw new Exception("La contraseña es incorrecta");
                }else{
                    return usuario;
                }
            }

            if(usuario==null){
                usuario = administradorHotelRepo.findByEmail(email).orElse(null);
            }else{
                if(!strongPasswordEncryptor.checkPassword(password,usuario.getPassword())){
                    throw new Exception("La contraseña es incorrecta");
                }else{
                    return usuario;
                }
            }

            if(usuario==null){
                throw new Exception("Los datos de autenticación son incorrectos");
            }else{
                if(!strongPasswordEncryptor.checkPassword(password,usuario.getPassword())){
                    throw new Exception("La contraseña es incorrecta");
                }else{
                    return usuario;
                }
            }
        }catch (EncryptionOperationNotPossibleException e){
            throw new Exception("La contraseña es incorrecta");
        }

    }

    @Override
    public List<AdministradorHotel> listarAdministradoresHotel() {
        return administradorHotelRepo.findAll();
    }


}
