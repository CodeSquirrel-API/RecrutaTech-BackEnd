package br.gov.sp.fatec.recrutatech.service.email;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.dto.EmailDto;
import br.gov.sp.fatec.recrutatech.entity.Email;
import br.gov.sp.fatec.recrutatech.repository.EmailRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository repository;
    private final JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String supportEmail;

    public Email sendEmail(Email email) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailToto());
            message.setSubject(email.getTitle());
            message.setText(email.getText());

            email.setSendDate(LocalDateTime.now());
            email.setSend(true);

            sender.send(message);
        } catch (MailException ex) {
            email.setSend(false);
            // log.warn("Erro na tentativa de envio de email. Message: {}",
            // ex.getMessage());
        } finally {
            repository.save(email);
        }

        return email;
    }

    public void sendEmailAuth(EmailDto email) throws MessagingException {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(supportEmail);
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        message.setTo(email.getEmail());

        sender.send(message);
    }

}