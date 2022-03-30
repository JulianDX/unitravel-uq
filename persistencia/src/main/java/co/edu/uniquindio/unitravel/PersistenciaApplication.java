package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PersistenciaApplication {

    public static void main(String[] args) {

        SpringApplication.run(PersistenciaApplication.class, args);

        Usuario persona = new Usuario("2436","Pedro","pedro@hotmail.com");

        Map<String, String> telefonos = new HashMap<>();

        telefonos.put("Casa","8850849");
        telefonos.put("Personal","3224250426");

        persona.setTelefono(telefonos);

    }

}
