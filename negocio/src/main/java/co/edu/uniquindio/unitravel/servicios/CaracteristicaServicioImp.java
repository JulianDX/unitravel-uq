package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaServicioImp implements CaracteristicaServicio{

    private final CaracteristicaRepo caracteristicaRepo;

    public CaracteristicaServicioImp(CaracteristicaRepo caracteristicaRepo) {
        this.caracteristicaRepo = caracteristicaRepo;
    }

    @Override
    public Caracteristica registrarCaracteristica(Caracteristica caracteristica){
        return caracteristicaRepo.save(caracteristica);
    }

    @Override
    public Caracteristica actualizarCaracteristica(Caracteristica caracteristica) {
        return caracteristicaRepo.save(caracteristica);
    }

    @Override
    public Caracteristica obtenerCaracteristica(int codigo) throws Exception {
        Caracteristica caracteristica = caracteristicaRepo.findById(codigo).orElse(null);
        if (caracteristica == null){
            throw new Exception("La caracteristica "+ codigo + "no existe");
        }
        return caracteristica;
    }

    @Override
    public void eliminarCaracteristica(int codigo) throws Exception {
        Caracteristica caracteristica = caracteristicaRepo.findById(codigo).orElse(null);
        if(caracteristica == null){
            throw new Exception("la caracteristica " + codigo + "no existe");
        }
        caracteristicaRepo.delete(caracteristica);
    }

    @Override
    public List<Caracteristica> obtenerCaracteristicas() {
        return caracteristicaRepo.obtenerListaCaracteristicas();
    }

    @Override
    public List<Caracteristica> obtenerCaracteristicasHoteles() {
        return caracteristicaRepo.obtenerCaracteristicasHotel();
    }

    @Override
    public List<Caracteristica> obtenerCaracteristicasHabitaciones() {
        return caracteristicaRepo.obtenerCaracteristicasHabitacion();
    }


}