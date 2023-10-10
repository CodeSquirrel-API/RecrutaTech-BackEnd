package br.gov.sp.fatec.recrutatech.controller;

import br.gov.sp.fatec.recrutatech.entity.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.sp.fatec.recrutatech.dto.messageDto;
import br.gov.sp.fatec.recrutatech.service.email.EmailService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
@CrossOrigin
@Api(tags = "Email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // @PostMapping("/send")
    // public ResponseEntity<Email> sendEmail(@RequestBody messageDto messageDto) {

    // Email email = new Email();
    // // email.setOwner(messageDto.getOwner());
    // // email.setEmailFrom(messageDto.getFrom());
    // // email.setEmailToto(messageDto.getTo());
    // // email.setTitle(messageDto.getTitle());
    // // email.setText(messageDto.getText());

    // email.setOwner("code squirrel");
    // email.setEmailFrom("codesquirrelfatec@gmail.com");
    // email.setEmailToto("fred.rbo23@gmail.com");
    // email.setTitle("ola teste");
    // email.setText("tesadasd");

    // Email emailSent = emailService.sendEmail(email);
    // return ResponseEntity.ok(emailSent);
    // }

    @PostMapping("/validar-code")
    public void sendEmailCode(@RequestBody String subject, @RequestBody String email, @RequestBody String content) {
        try {
            emailService.sendEmailAuth(subject, email, content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
