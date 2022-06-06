package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.servicios.ReservaServicio;
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
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Component
@ViewScoped
public class ReservaBean implements Serializable {

    @Autowired
    private ReservaServicio reservaServicio;

    @Getter @Setter
    private List<Reserva> listaReservas;

    @Value(value = "#{seguridadBean.persona}")
    private Cliente clienteSesion;

    @Getter @Setter
    private Reserva reserva;

    @Getter @Setter
    private Reserva reservaSeleccionada;

    @PostConstruct
    public void init() {
        reservaSeleccionada = new Reserva();
        try {
            listaReservas = reservaServicio.listarReservasCliente(clienteSesion.getCedula());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void cancelarReserva() {

        reserva.setEstado("Cancelado");
        try {
            reservaServicio.actualizarReserva(reserva);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción procesada", "Procesado con éxito");
            FacesContext.getCurrentInstance().addMessage("reserva-bean", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("reserva-bean", fm);
        }
    }

    public String obtenerFechaComentario(LocalDateTime fecha) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(formato);
    }

    public String obtenerNombreHotel(Reserva reserva) {

        try {
            return reservaServicio.obtenerHotelReserva(reserva.getCodigo()).get(0).getNombre();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "";
    }

    public void seleccionarReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setReservaSeleccionada(Reserva reservaSelec) {
        reservaSeleccionada = reservaSelec;
    }

    public String convertirValorTotal(Reserva reserva) {

        Locale locale = new Locale("es", "CO");
        NumberFormat formato = NumberFormat.getCurrencyInstance(locale);
        return formato.format(reserva.getPrecioTotal());
    }

}

