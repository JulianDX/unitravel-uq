package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.EmailService;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Component
@ViewScoped
public class ClienteBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Autowired
    EmailService emailService;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private String pass_reset;

    @Getter @Setter
    private Persona clientePass;

    @PostConstruct
    public void init(){
        cliente = new Cliente();
        ciudades = unitravelServicio.listarCiudades();
        clientePass = new Persona();
        pass_reset = "";
    }

    public void registrarCliente(){
        try {
            clienteServicio.registrarCliente(cliente);
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage("msj_bean",facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj_bean",facesMsg);
        }
    }

    public void recuperarPassword(){

        clientePass = clienteServicio.obtenerClientePorCorreo(this.pass_reset);

        if(clientePass!=null){
            emailService.enviarCorreo("Recuperación de contraseña","Hola "+clientePass.getNombre()+", su contraseña es: "+clientePass.getPassword(),this.pass_reset);

            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Correo enviado");
            FacesContext.getCurrentInstance().addMessage("msj_user", facesMsg);
        }else{
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo no está registrado");
            FacesContext.getCurrentInstance().addMessage("msj_user",facesMsg);
        }
    }

}
