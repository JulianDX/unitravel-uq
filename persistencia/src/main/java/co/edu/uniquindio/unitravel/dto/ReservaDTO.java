package co.edu.uniquindio.unitravel.dto;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservaDTO {

    private String nombreCliente;
    private LocalDateTime fechaReserva;
    private Habitacion habitacion;


}