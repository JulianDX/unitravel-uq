package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;

import java.util.List;

public interface AdministradorServicio {

    List<AdministradorHotel> listarAdminsH();

    AdministradorHotel obtenerAmindH(String codigo);

    AdministradorHotel crearAdminH(AdministradorHotel administradorHotel) throws Exception;

    void eliminarAdminH(AdministradorHotel administradorHotel) throws Exception;

    void crearCiudad(Ciudad ciudad) throws Exception;

    void eliminarCiudad(Ciudad c) throws Exception;




}
