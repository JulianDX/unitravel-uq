package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitacionServicioImpl implements HabitacionServicio {


    private final HabitacionRepo habitacionRepo;
    private final ReservaRepo reservaRepo;

    public HabitacionServicioImpl(HabitacionRepo habitacionRepo, ReservaRepo reservaRepo) {
        this.habitacionRepo = habitacionRepo;
        this.reservaRepo = reservaRepo;
    }

    @Override
    public Habitacion crearHabitacion(Habitacion habitacion) throws Exception {
        if (habitacion.getPrecio() <= 0)
            throw new Exception("El valor de la habitación debe ser mayor a 0");

        if (habitacion.getCapacidad() <= 0)
            throw new Exception("La capacidad de la habitacion debe ser mayor a 0");
        return habitacionRepo.save(habitacion);
    }

    @Override
    public Habitacion actualizarHabitacion(Habitacion habitacion) throws Exception {
        if (habitacion.getPrecio() <= 0)
            throw new Exception("El valor de la habitación debe ser mayor a 0");

        if (habitacion.getCapacidad() <= 0)
            throw new Exception("La capacidad de la habitacion debe ser mayor a 0");
        return habitacionRepo.save(habitacion);
    }

    @Override
    public Habitacion obtenerHabitacion(int codigo) throws Exception {
        Habitacion habitacion = habitacionRepo.findById(codigo).orElse(null);
        if (habitacion == null) {
            throw new Exception("La habitación " + codigo + "no existe");
        }
        return habitacion;
    }

    @Override
    public void eliminarHabitacion(int codigo) throws Exception {
        Habitacion habitacion = habitacionRepo.findById(codigo).orElse(null);
        if (habitacion == null) {
            throw new Exception("La habitacion " + codigo + "No existe");
        }
        habitacionRepo.delete(habitacion);
    }


    @Override
    public List<Habitacion> obtenerHabitaciones() {
        return habitacionRepo.obtenerListaHabitaciones();
    }

    @Override
    public List<Habitacion> obtenerHabitacionesDisponibles(LocalDateTime fechaInicioReserva, LocalDateTime fechaFinReserva, int codigoHotel) {
        return habitacionRepo.consultarDisponibilidadHabitacion(fechaInicioReserva, fechaFinReserva, codigoHotel);
    }

}

