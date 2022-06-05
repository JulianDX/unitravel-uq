package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetalleHotelBean implements Serializable {

    @Value("#{param['hotel_id']}")
    private String codigoHotel;

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private Comentario nuevoComentario;

    @Getter @Setter
    List<Comentario> comentarios;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Value("#{seguridadBean.persona}")
    private Persona personaSesion;

    @PostConstruct
    public void inicializar(){
        nuevoComentario = new Comentario();
        comentarios = new ArrayList<>();
        if(codigoHotel!=null && !codigoHotel.isEmpty()){
            try {
                hotel = unitravelServicio.obtenerHotel(Integer.parseInt(codigoHotel));
                comentarios = hotel.getComentarios();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void crearComentario(){
        try {
            if(personaSesion!=null){
                nuevoComentario.setHotel(this.hotel);
                nuevoComentario.setCliente( (Cliente) personaSesion );
                unitravelServicio.crearComentario(nuevoComentario);
                this.comentarios.add(nuevoComentario);
                this.nuevoComentario = new Comentario();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
