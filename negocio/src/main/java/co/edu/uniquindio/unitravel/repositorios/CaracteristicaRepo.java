package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicaRepo extends JpaRepository<Caracteristica,Integer> {

    List<Caracteristica> findAllByTipo(String tipo);

    @Query("select  c from Caracteristica  c where c.estado = 'A'")
    List<Caracteristica> obtenerListaCaracteristicas();

    @Query("select c from Caracteristica c where c.estado = 'A' and c.tipo = 1")
    List<Caracteristica>obtenerCaracteristicasHotel();

    @Query("select c from Caracteristica c where c.estado = 'A' and c.tipo = 2")
    List<Caracteristica>obtenerCaracteristicasHabitacion();


}
