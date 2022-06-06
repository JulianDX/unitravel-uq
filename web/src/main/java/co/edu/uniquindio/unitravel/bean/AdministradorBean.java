package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class AdministradorBean implements Serializable {

    @Getter @Setter
    List<AdministradorHotel> adminsHotel;

    @Autowired
    AdministradorServicio administradorServicio;

    @Getter @Setter
    AdministradorHotel administradorHotel;

    @Getter @Setter
    AdministradorHotel adminAuxiliar;

    @Value("#{param['adminh_id']}")
    private String cedulaAdminH;

    @Value("#{seguridadBean.persona}")
    private Persona personaSesion;

    @PostConstruct
    public void inicializar() {
            adminsHotel = administradorServicio.listarAdminsH();
            adminAuxiliar = new AdministradorHotel();
       if(cedulaAdminH!=null){
           administradorHotel = administradorServicio.obtenerAmindH(cedulaAdminH);
       }
    }

    public String irModificarAdminH(String cedula){
        return "modificar_adminh?faces-redirect=true&amp;adminh_id="+cedula;
    }

    public String irCrearAdminH(){
        return "crear_adminh?faces-redirect=true";
    }

    public void modificarAdminH(AdministradorHotel administradorHotel){
        if(personaSesion!=null){

            try{
                this.administradorHotel.setNombre(adminAuxiliar.getNombre());
                this.administradorHotel.setEmail(adminAuxiliar.getEmail());
                this.administradorHotel.setPassword(adminAuxiliar.getPassword());

                administradorServicio.crearAdminH(this.administradorHotel);

                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Administrador de hotel actualizado");
                FacesContext.getCurrentInstance().addMessage("msj_bean", facesMsg);

            }catch(Exception e){

            }

        }
    }

    public void crearAdminH(AdministradorHotel administradorHotel){
        if(personaSesion!=null){

            try{

                administradorServicio.crearAdminH(administradorHotel);

                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Administrador de hotel creado");
                FacesContext.getCurrentInstance().addMessage("msj_bean", facesMsg);

            }catch(Exception e){

            }

        }
    }

    public void eliminarAdminH(AdministradorHotel administradorHotel){

        if(administradorHotel!=null){
            if(personaSesion!=null){
                try {
                    administradorServicio.eliminarAdminH(administradorHotel);
                    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Administrador de hotel eliminado");
                    FacesContext.getCurrentInstance().addMessage("msj_bean", facesMsg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
