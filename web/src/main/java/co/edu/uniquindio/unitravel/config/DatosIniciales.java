package co.edu.uniquindio.unitravel.config;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements CommandLineRunner {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;
    @Autowired
    private AdministradorServicio administradorServicio;
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @Autowired
    private CaracteristicaServicio caracteristicaServicio;


    @Override
    public void run(String... args) throws Exception {

        administradorServicio.crearAdminH(new AdministradorHotel("3884939384","adh@hotmail.com","Sebastian","K82knpdMa+w6Wwo45hO5JyO0nU07g+780xWodDJhQHgSXKprSI4/V0EOxx/iuUcO"));
        administradorServicio.crearAdminH(new AdministradorHotel("4883884838","adh2@hotmail.com","Pedro","K82knpdMa+w6Wwo45hO5JyO0nU07g+780xWodDJhQHgSXKprSI4/V0EOxx/iuUcO"));

        if(unitravelServicio.listarCiudades().isEmpty()){

            administradorServicio.crearCiudad(new Ciudad("Armenia", "https://i.pinimg.com/originals/c2/05/2f/c2052fdeb705be24b21b46f85c989cd2.jpg"));
            administradorServicio.crearCiudad(new Ciudad("Bogota","https://cloudfront-us-east-1.images.arcpublishing.com/infobae/JAAYCWLOQRHOTKSLAZAH37REYM.jpeg"));
            administradorServicio.crearCiudad(new Ciudad("Cartagena", "https://cdn.colombia.com/images/v2/turismo/sitios-turisticos/cartagena/ciudad-cartagena-800.jpg"));
            administradorServicio.crearCiudad(new Ciudad("Medellin","https://cdn.forbes.co/2020/09/Medell%C3%ADn-foto-ProColombia.jpg"));
            administradorServicio.crearCiudad(new Ciudad("Cali", "https://upload.wikimedia.org/wikipedia/commons/4/4e/Santiago_de_Cali.jpg"));

            caracteristicaServicio.registrarCaracteristica(new Caracteristica (1,"Wi-Fi","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (2,"Sauna","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (3,"Piscina","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (4,"Lavanderia","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (5,"Restaurante","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (6,"Bar","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (7,"SPA","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (8,"Bufet","1"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (9,"Servicio al cuarto","2"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (10,"Jacuzzi","2"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (11,"Refrigerador","2"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (12,"Toallas","2"));
            caracteristicaServicio.registrarCaracteristica(new Caracteristica (13,"Kit limpieza","2"));

        }

    }
}
