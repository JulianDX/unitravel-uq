package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorImpl implements AdministradorServicio{

    private AdministradorHotelRepo administradorHotelRepo;
    private CiudadRepo ciudadRepo;

        public AdministradorImpl(AdministradorHotelRepo administradorHotelRepo, CiudadRepo ciudadRepo){
            this.administradorHotelRepo = administradorHotelRepo;
            this.ciudadRepo = ciudadRepo;
        }


    @Override
    public List<AdministradorHotel> listarAdminsH() {
        return administradorHotelRepo.findAll();
    }

    @Override
    public AdministradorHotel obtenerAmindH(String codigo) {
        return administradorHotelRepo.findById(codigo).orElse(null);
    }

    @Override
    public AdministradorHotel crearAdminH(AdministradorHotel administradorHotel) throws Exception {
        return administradorHotelRepo.save(administradorHotel);
    }

    @Override
    public void eliminarAdminH(AdministradorHotel administradorHotel) throws Exception {
        administradorHotelRepo.delete(administradorHotel);
    }

    @Override
    public void crearCiudad(Ciudad ciudad) throws Exception {
        ciudadRepo.save(ciudad);
    }

    @Override
    public void eliminarCiudad(Ciudad c) throws Exception {
        ciudadRepo.delete(c);
    }
}
