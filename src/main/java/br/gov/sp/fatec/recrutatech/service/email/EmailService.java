package br.gov.sp.fatec.recrutatech.service.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
    
import br.gov.sp.fatec.recrutatech.dto.emailDto;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String supportEmail;

    public void sendEmailAuth(emailDto email) throws MessagingException {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(supportEmail);
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        message.setTo(email.getEmail());

        sender.send(message);
    }

}