package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.VueloRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloTest {

    @Autowired
    private VueloRepo vueloRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void ListarVuelosCiudad(){
        List<Vuelo> vuelos = vueloRepository.obtenerVuelos("Bogota");
        vuelos.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void ListarVuelosAerolinea(){
        List<Vuelo> vuelosAerolinea = vueloRepository.obtenerVuelosAerolinea("avianca");
        vuelosAerolinea.forEach(System.out::println);
    }
}