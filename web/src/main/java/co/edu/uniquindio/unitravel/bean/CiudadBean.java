package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class CiudadBean {

    @Value("#{param['ciudad_id']}")
    private String codigoCiudad;

    @Getter @Setter
    Ciudad ciudad;

    @Value("#{seguridadBean.persona}")
    private Persona personaSesion;

    @Getter @Setter
    Ciudad ciudadNueva;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    AdministradorServicio administradorServicio;

    @Getter @Setter
    List<Ciudad> ciudades;

    @Autowired
    UnitravelServicio unitravelServicio;

    @PostConstruct
    public void inicializar(){
        ciudades = unitravelServicio.listarCiudades();
        ciudadNueva = new Ciudad();
        if(codigoCiudad!=null && !codigoCiudad.isEmpty()){
            try {
                ciudad = clienteServicio.obtenerCiudad(Integer.parseInt(codigoCiudad));

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public String irCrearCiudad(){
        return "crear_ciudad?faces-redirect=true";
    }

    public void crearCiudad(){
        if(personaSesion!=null){

            try {
                administradorServicio.crearCiudad(this.ciudadNueva);
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Destino creado");
                FacesContext.getCurrentInstance().addMessage("msj_bean", facesMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public String irModificarCiudad(Ciudad ciudad){
        return "modificar_ciudad?faces-redirect=true&amp;ciudad_id="+ciudad.getCodigo();
    }

    public void eliminarCiudad(Ciudad ciudad){
        if(personaSesion!=null){
            try {
                administradorServicio.eliminarCiudad(ciudad);
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Destino eliminado");
                FacesContext.getCurrentInstance().addMessage("msj_bean", facesMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}