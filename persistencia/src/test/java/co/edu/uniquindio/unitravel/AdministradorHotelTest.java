package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
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
public class AdministradorHotelTest {

    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;

    @Test
    public void registrar(){

        AdministradorHotel administrador = new AdministradorHotel("123123","admin@hotmail.com","Carlos","carlos123");
        AdministradorHotel adminGuardado = administradorHotelRepo.save(administrador);

        Assertions.assertNotNull(adminGuardado);

    }

    @Test
    public void eliminar(){

        AdministradorHotel administrador = new AdministradorHotel("123123","admin@hotmail.com","Carlos","carlos123");
        AdministradorHotel adminGuardado = administradorHotelRepo.save(administrador);

        administradorHotelRepo.delete(adminGuardado);

        AdministradorHotel adminBuscado = administradorHotelRepo.findById("123123").orElse(null);

        Assertions.assertNull(adminBuscado);

    }

    @Test
    public void actualizar(){

        AdministradorHotel administrador = new AdministradorHotel("123123","admin@hotmail.com","Carlos","carlos123");
        AdministradorHotel adminGuardado = administradorHotelRepo.save(administrador);

        adminGuardado.setPassword("pruebaCambio");
        administradorHotelRepo.save(adminGuardado);

        AdministradorHotel adminBuscado = administradorHotelRepo.findById("123123").orElse(null);
        Assertions.assertEquals("pruebaCambio",adminBuscado.getPassword());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<AdministradorHotel> administradors = administradorHotelRepo.findAll();

        administradors.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPorNombre(){

        List<AdministradorHotel> admins = administradorHotelRepo.listarAdministradoresHotelPorNombre("Viviana");
        admins.forEach(System.out::println);
        Assertions.assertEquals(1,admins.size());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void Autenticacion(){

        Optional<AdministradorHotel> adminAutenticado = administradorHotelRepo.Autenticacion("admin1@hotmail.com","vivi123");
        System.out.println(adminAutenticado.get());

        Assertions.assertNotNull(adminAutenticado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdministradoresPaginador(){

        Page<AdministradorHotel> admins = administradorHotelRepo.findAll(PageRequest.of(0,2));
        admins.get().forEach(System.out::println);
        Assertions.assertNotEquals(0,admins.getSize());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPorCedula(){

        Optional<AdministradorHotel> admin = administradorHotelRepo.listarAdministradoresHotelPorCedula("654321");
        System.out.println(admin.get());

        Assertions.assertNotNull(admin);

    }

}
