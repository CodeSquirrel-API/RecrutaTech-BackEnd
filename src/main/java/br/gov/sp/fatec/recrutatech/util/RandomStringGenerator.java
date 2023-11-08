package br.gov.sp.fatec.recrutatech.util;

import java.util.Random;

public class RandomStringGenerator {


    public String gerarStringAleatoria(int length) {
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            sb.append(caracteresPermitidos.charAt(index));
        }

        return sb.toString();
    }
    
}
