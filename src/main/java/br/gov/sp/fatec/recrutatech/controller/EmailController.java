package br.gov.sp.fatec.recrutatech.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/email")
@CrossOrigin
@Api(tags = "Email")
public class EmailController {

    // @Autowired
    // private EmailService emailService;

    // @PostMapping("/validar-code")
    // public void sendEmailCode(@RequestBody EmailDto email) {
        // try {
        //     emailService.sendEmailAuth(email);
        // } catch (MessagingException e) {
        //     e.printStackTrace();
        // }

    // }
}
