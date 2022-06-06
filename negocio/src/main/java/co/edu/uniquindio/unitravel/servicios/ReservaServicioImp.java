package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaServicioImp implements ReservaServicio {


    private final ReservaRepo reservaRepo;
    private final EmailServicio emailServicio;
    public ReservaServicioImp(ReservaRepo reservaRepo, EmailServicio emailServicio) {
        this.reservaRepo = reservaRepo;
        this.emailServicio = emailServicio;
    }

    @Override
    public Reserva registrarReserva(Reserva reserva) throws Exception {

        //Se suma el valor del iva 19%
        reserva.setPrecioTotal(reserva.getPrecioTotal() + (reserva.getPrecioTotal()*19)/100);

        if (reserva.getFechaInicio().isAfter(reserva.getFechaFin())) {
            throw new Exception("La fecha inicio" + reserva.getFechaInicio() + " es mayor a la fecha fin " + reserva.getFechaFin());
        }
        if (reserva.getCantidadPersonas() <= 0) {
            throw new Exception("La cantidad de personas debe ser mayor a 0");
        }
        if (reserva.getPrecioTotal() <= 0) {
            throw new Exception("El precio total debe ser mayor a 0");
        }
        //Se envía el correo electrónico del usuario
        emailServicio.EnviarEmail("Reserva Unitravel", obtenerDescripcionReserva(reserva), reserva.getCliente().getEmail());

        return reservaRepo.save(reserva);
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) throws Exception {

        //Se suma el valor del iva 19%
        reserva.setPrecioTotal(reserva.getPrecioTotal() + (reserva.getPrecioTotal()*19)/100);

        if (reserva.getFechaInicio().isAfter(reserva.getFechaFin())) {
            throw new Exception("La fecha inicio" + reserva.getFechaInicio() + " es mayor a la fecha fin " + reserva.getFechaFin());
        }
        if (reserva.getCantidadPersonas() <= 0) {
            throw new Exception("La cantidad de personas debe ser mayor a 0 ");
        }
        if (reserva.getPrecioTotal() <= 0) {
            throw new Exception("El precio total debe ser mayor a 0");
        }
        emailServicio.EnviarEmail("Modificación Reserva Unitravel", obtenerDescripcionReserva(reserva), reserva.getCliente().getEmail());
        return reservaRepo.save(reserva);
    }

    @Override
    public Reserva obtenerReserva(int codigo) throws Exception {
        Reserva reserva = reservaRepo.getById(codigo);
        if(reserva == null)
            throw new Exception("La reserva " + codigo +" no existe");
        return reserva;
    }

    @Override
    public void eliminarReserva(int codigo) throws Exception {
        Reserva reserva = reservaRepo.getById(codigo);
        if(reserva == null)
            throw new Exception("La reserva " + codigo +" no existe");
        reservaRepo.delete(reserva);

    }

    @Override
    public List<Reserva> obtenerReservas() {
        return reservaRepo.obtenerListaReservas();
    }

    @Override
    public List<Reserva> listarReservasCliente(String cedula) {
        return reservaRepo.listaReservasCliente(cedula);
    }

    @Override
    public List<Hotel> obtenerHotelReserva(Integer idReserva) throws Exception {
        return reservaRepo.hotelReserva(idReserva);
    }

    private String obtenerDescripcionReserva (Reserva reserva){
        return  "Se ha actualizado la reserva correctamente \n" +
                "Detalles: \n\n" +
                "Fecha inicio: " + reserva.getFechaInicio() +
                "\nFecha fin " + reserva.getFechaFin() +
                "\nNumero de personas: " + reserva.getCantidadPersonas() +
                "\nValor total: " + reserva.getPrecioTotal();
    }


}
