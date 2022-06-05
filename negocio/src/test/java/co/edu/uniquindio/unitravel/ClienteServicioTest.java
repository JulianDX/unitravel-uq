package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.ClienteServicioImpl;
import co.edu.uniquindio.unitravel.servicios.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class ClienteServicioTest {

    @Autowired
    private ClienteServicioImpl clienteServicio;

    @Autowired
    private EmailService emailService;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest(){

        Cliente cliente = new Cliente("123456","Pedro","mail2@hotmail.com","test123");

        try {
            Cliente guardado = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest(){
        Cliente cliente = clienteServicio.obtenerCliente("123456");
        cliente.setPassword("cambiando123");

        try {
            Cliente actualizado = clienteServicio.actualizarCliente(cliente);
            Assertions.assertEquals("cambiando123",actualizado.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest(){
        try {
            clienteServicio.eliminarCliente("9994999");
            Cliente eliminado = clienteServicio.obtenerCliente("999999");
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClienteTest(){
        List<Cliente> clientes = clienteServicio.listarClientes();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void enviarCorreoTest() {
        boolean estado = emailService.enviarCorreo("Prueba","Este es un mensaje","jfroap@uqvirtual.edu.co");
    }

}
