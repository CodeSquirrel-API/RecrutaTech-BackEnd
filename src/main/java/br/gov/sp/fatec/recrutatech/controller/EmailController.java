package br.gov.sp.fatec.recrutatech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.dto.EmailDto;
import br.gov.sp.fatec.recrutatech.service.email.EmailService;
import io.swagger.annotations.Api;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
@CrossOrigin
@Api(tags = "Email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/validar-code")
    public void sendEmailCode(@RequestBody EmailDto email) {
        try {
            emailService.sendEmailAuth(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
