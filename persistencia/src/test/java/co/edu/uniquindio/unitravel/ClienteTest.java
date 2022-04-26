package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
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
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar(){

        Cliente cliente = new Cliente("1020838034","Julian","jfroap@uqvirtual.edu.co","test123");
        Cliente clienteGuardado = clienteRepo.save(cliente);

        Assertions.assertNotNull(clienteGuardado);

    }

    @Test
    public void eliminar(){

        Cliente cliente = new Cliente("1020838034","Julian","jfroap@uqvirtual.edu.co","test123");
        Cliente clienteGuardado = clienteRepo.save(cliente);

        clienteRepo.delete(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("1020838034").orElse(null);

        Assertions.assertNull(clienteBuscado);

    }

    @Test
    public void actualizar(){

        Cliente cliente = new Cliente("1020838034","Julian","jfroap@uqvirtual.edu.co","test123");
        Cliente clienteGuardado = clienteRepo.save(cliente);

        clienteGuardado.setPassword("pruebaCambio");
        clienteRepo.save(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("1020838034").orElse(null);
        Assertions.assertEquals("pruebaCambio",clienteBuscado.getPassword());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Cliente> clientes = clienteRepo.findAll();

        System.out.println(clientes);

    }

}
