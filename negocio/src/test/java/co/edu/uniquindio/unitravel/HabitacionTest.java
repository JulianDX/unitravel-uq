package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HabitacionTest {

    @Autowired
    private HabitacionRepo habitacionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHabitacionesPorRangoDePrecio(){

        List<Habitacion> habitaciones = habitacionRepo.listarHabitacionesPorRangoDePrecio(200500.0,350000.0);
        habitaciones.forEach(System.out::println);

        Assertions.assertNotEquals(0, habitaciones.size());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHabitacionesPorCapacidad(){

        List<Habitacion> habitaciones = habitacionRepo.listarHabitacionesPorCapacidad(2);
        habitaciones.forEach(System.out::println);

        Assertions.assertNotEquals(0, habitaciones.size());

    }

}
