package br.gov.sp.fatec.recrutatech.util;

import java.util.Random;


public class RandomCodeGenerator {
    
    public static String generateCode(int length) {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            code.append(random.nextInt(10));
        }

        return code.toString();
    }
}
