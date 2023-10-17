package br.gov.sp.fatec.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.recrutatech.dto.EmailDto;
import br.gov.sp.fatec.recrutatech.service.email.EmailService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/email")
@CrossOrigin
@Api(tags = "Email")
public class EmailController {

    
    @Autowired
    private EmailService emailService;

    @PostMapping("/send-code")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDto email) {
        try {
            emailService.sendVerificationCodeEmail(email);
            return ResponseEntity.ok("Email enviado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao enviar o email: " + e.getMessage());
        }
    }

    @PostMapping("/check-code")
    public ResponseEntity<String> verificarCodigo(
            @RequestParam String email,
            @RequestParam Integer codigo) {

        if (emailService.checkCode(email, codigo)) {
            return ResponseEntity.ok("Código correto!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código incorreto!");
        }
    }

}
