package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPorNombre(){

        List<Hotel> hoteles = hotelRepo.listarHotelesPorNombre("Eco");
        hoteles.forEach(System.out::println);

        Assertions.assertNotEquals(0, hoteles.size());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPorEstrellas(){

        List<Hotel> hoteles = hotelRepo.listarHotelesPorEstrellas(4);
        hoteles.forEach(System.out::println);

        Assertions.assertNotEquals(0, hoteles.size());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPorCiudad(){

        List<Hotel> hoteles = hotelRepo.listarHotelesPorCiudad("Pereira");
        hoteles.forEach(System.out::println);

        Assertions.assertNotEquals(0, hoteles.size());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotel(){

        Hotel hotel = hotelRepo.findByNombreAndDireccion("Hotel Deluaxe","Carrera 5 #20-34");
        System.out.println(hotel);

        Assertions.assertNotNull(hotel);

    }

}
