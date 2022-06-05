package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;

@Component
@ViewScoped
public class CiudadBean {

    @Value("#{param['ciudad_id']}")
    private String codigoCiudad;

    @Getter @Setter
    Ciudad ciudad;

    @Autowired
    ClienteServicio clienteServicio;

    @PostConstruct
    public void inicializar(){

        if(codigoCiudad!=null && !codigoCiudad.isEmpty()){
            try {
                ciudad = clienteServicio.obtenerCiudad(Integer.parseInt(codigoCiudad));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
