package br.gov.sp.fatec.recrutatech.service.email;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.config.EmailConfig;
import br.gov.sp.fatec.recrutatech.dto.EmailDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final HashMap<String, Integer> codigos = new HashMap<>();

    public void sendVerificationCodeEmail(EmailDto email) {
        EmailConfig emailConfig = new EmailConfig();
        JavaMailSender emailSender = emailConfig.javaMailSender();
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email.getEmail());
        message.setSubject("RecrutaTech: Código de verificação");

        Integer[] randomNumbers = generateRandomNumbers(6); // Gera 6 números aleatórios
        String code = Arrays.stream(randomNumbers)
                .map(Object::toString)
                .collect(Collectors.joining(""));

        String htmlContent =  "Olá, seu código de verificação é:" + code;
        message.setText(htmlContent);
        codigos.put(email.getEmail(), Integer.parseInt(code));
        emailSender.send(message);

        System.out.println("Email sent successfully....");
    }

    public void sendNewPassword(EmailDto email,String password) {
        EmailConfig emailConfig = new EmailConfig();
        JavaMailSender emailSender = emailConfig.javaMailSender();
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email.getEmail());
        message.setSubject("RecrutaTech: Sua nova senha");

        String htmlContent = "Olá, sua nova senha é:" + password;
        message.setText(htmlContent);
        emailSender.send(message);

        System.out.println("Email sent successfully....");
    }



    public boolean checkCode(String email, Integer codigo) {
        Object codigoArmazenado = codigos.get(email);

        if (codigoArmazenado != null) {
            Integer codigoArmazenadoInt = (Integer) codigoArmazenado;
            return codigo.equals(codigoArmazenadoInt);
        }

        return false;
    }

    public static Integer[] generateRandomNumbers(Integer count) {
        Random random = new Random();
        Integer[] randomNumbers = new Integer[count];

        for (int i = 0; i < count; i++) {
            randomNumbers[i] = random.nextInt(10);
        }

        return randomNumbers;
    }
}