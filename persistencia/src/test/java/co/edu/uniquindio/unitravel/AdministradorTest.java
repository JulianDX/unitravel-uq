package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    public void registrar(){

        Administrador administrador = new Administrador("123123","admin@hotmail.com","Carlos","carlos123");
        Administrador adminGuardado = administradorRepo.save(administrador);

        Assertions.assertNotNull(adminGuardado);

    }

    @Test
    public void eliminar(){

        Administrador administrador = new Administrador("123123","admin@hotmail.com","Carlos","carlos123");
        Administrador adminGuardado = administradorRepo.save(administrador);

        administradorRepo.delete(adminGuardado);

        Administrador adminBuscado = administradorRepo.findById("123123").orElse(null);

        Assertions.assertNull(adminBuscado);

    }

    @Test
    public void actualizar(){

        Administrador administrador = new Administrador("123123","admin@hotmail.com","Carlos","carlos123");
        Administrador adminGuardado = administradorRepo.save(administrador);

        adminGuardado.setPassword("pruebaCambio");
        administradorRepo.save(adminGuardado);

        Administrador adminBuscado = administradorRepo.findById("123123").orElse(null);
        Assertions.assertEquals("pruebaCambio",adminBuscado.getPassword());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Administrador> administradors = administradorRepo.findAll();

        administradors.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPorNombre(){

        List<Administrador> admins = administradorRepo.listarAdministradoresPorNombre("Viviana");
        admins.forEach(System.out::println);
        Assertions.assertEquals(1,admins.size());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Autenticacion(){

        Optional<Administrador> adminAutenticado = administradorRepo.Autenticacion("admin1@hotmail.com","vivi123");
        System.out.println(adminAutenticado.get());

        Assertions.assertNotNull(adminAutenticado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdministradoresPaginador(){

        Page<Administrador> admins = administradorRepo.findAll(PageRequest.of(0,2));
        admins.get().forEach(System.out::println);
        Assertions.assertNotEquals(0,admins.getSize());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPorCedula(){

        Optional<Administrador> admin = administradorRepo.listarAdministradoresPorCedula("654321");
        System.out.println(admin.get());

        Assertions.assertNotNull(admin);

    }

}
