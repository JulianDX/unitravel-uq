package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private Persona persona;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private int rol;

    @Getter @Setter
    AdministradorHotel adminh;

    @PostConstruct
    public void inicializar(){
        adminh = new AdministradorHotel();
    }

    public String iniciarSesion(){
        try {
           persona = unitravelServicio.validarLogin(email,password);
           autenticado = true;

           if(persona instanceof Cliente){
               rol = 1;
           }else if(persona instanceof AdministradorHotel){
               rol = 2;
               adminh =  (AdministradorHotel) persona;
           }else{
               rol = 3;
           }

           return "/index?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("login-bean",facesMsg);
        }
        return null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }


}
