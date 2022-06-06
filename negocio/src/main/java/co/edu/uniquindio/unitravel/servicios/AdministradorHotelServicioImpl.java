package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio {

    private AdministradorHotelRepo administradorHotelRepo;
    private HotelRepo hotelRepo;
    private CiudadRepo ciudadRepo;
    private HabitacionRepo habitacionRepo;

    public AdministradorHotelServicioImpl(AdministradorHotelRepo administradorHotelRepo, HotelRepo hotelRepo, CiudadRepo ciudadRepo, HabitacionRepo habitacionRepo){
        this.administradorHotelRepo = administradorHotelRepo;
        this.hotelRepo = hotelRepo;
        this.ciudadRepo = ciudadRepo;
        this.habitacionRepo = habitacionRepo;
    }

    @Override
    public Hotel crearHotel(Hotel h) throws Exception {
        Hotel hotel = obtenerHotel(h.getNombre(),h.getDireccion());

        if(hotel!=null){
            throw new Exception("Ya se encuentra un hotel registrado con el nombre: "+hotel.getNombre()+" en la dirección:"+hotel.getDireccion());
        }
        return hotelRepo.save(h);
    }

    @Override
    public Habitacion crearHabitacion(Habitacion h) throws Exception {
        Habitacion habitacion = obtenerHabitacion(h.getNumero());

        if(habitacion!=null){
            throw new Exception("Ya se encuentra una habitación registrada con el número: "+h.getNumero());
        }
    return habitacionRepo.save(h);
    }

    @Override
    public Hotel obtenerHotel(String nombre, String direccion) throws Exception{
        return hotelRepo.findByNombreAndDireccion(nombre,direccion);
    }

    @Override
    public Habitacion obtenerHabitacion(Integer numero) throws Exception {
        return habitacionRepo.findById(numero).orElse(null);
    }

    @Override
    public AdministradorHotel obtenerAdmin(String codigo) {
        return administradorHotelRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Hotel obtenerHotel(Integer codigo) throws Exception{
        return hotelRepo.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarHotel(Hotel hotel) throws Exception {
        hotelRepo.delete(hotel);
    }


}
