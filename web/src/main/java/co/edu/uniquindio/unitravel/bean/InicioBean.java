package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class InicioBean implements Serializable {

    @Getter @Setter
    private List<Hotel> hoteles;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Hotel> hotelesRecomendados;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @PostConstruct
    public void inicializar(){
        try {
            hotelesRecomendados = clienteServicio.ListarHotelsPorNumeroEstrellas(4);
            hoteles = clienteServicio.listarHoteles();
            ciudades = unitravelServicio.listarCiudades();
        } catch (Exception e) {


        }
    }

    public String irRegistro(){
        return "registrar_cliente?faces-redirect=true";
    }


    public String irDetalleHotel(String codigoHotel){
        return "detalle_hotel?faces-redirect=true&amp;hotel_id="+codigoHotel;
    }

    public String irCiudadHotel(String codigoCiudad){
        return "ciudad_hoteles?faces-redirect=true&amp;ciudad_id="+codigoCiudad;
    }

}
