package co.edu.uniquindio.unitravel.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender sender;

        public boolean enviarCorreo(String asunto, String contenido, String destinatario){
            MimeMessage mensaje = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje);

            try {
                helper.setText(contenido,true);
                helper.setTo(destinatario);
                helper.setSubject(asunto);

                sender.send(mensaje);

                return true;
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return false;
        }

}
