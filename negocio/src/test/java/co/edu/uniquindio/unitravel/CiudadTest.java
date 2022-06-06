package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void registrar(){

        Ciudad ciudad = new Ciudad(1,"Pereira");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        Assertions.assertNotNull(ciudadGuardada);

    }

    @Test
    public void eliminar(){

        Ciudad ciudad = new Ciudad(1,"Pereira");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        ciudadRepo.delete(ciudadGuardada);

        Ciudad ciudadBuscada = ciudadRepo.findById(1).orElse(null);

        Assertions.assertNull(ciudadBuscada);

    }

    @Test
    public void actualizar(){

        Ciudad ciudad = new Ciudad(1,"Pereira");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        ciudadGuardada.setNombre("Armenia");
        ciudadRepo.save(ciudadGuardada);

        Ciudad ciudadBuscada = ciudadRepo.findById(1).orElse(null);
        Assertions.assertEquals("Armenia",ciudadBuscada.getNombre());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Ciudad> clientes = ciudadRepo.findAll();

        clientes.forEach(System.out::println);

    }

}
