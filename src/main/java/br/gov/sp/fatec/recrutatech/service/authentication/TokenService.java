package br.gov.sp.fatec.recrutatech.service.authentication;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.gov.sp.fatec.recrutatech.entity.User;

@Service
public class TokenService {


    public String gerarToken (User user){
       
            return JWT.create()
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(LocalDateTime.now()
                    .plusMinutes(30)
                    .toInstant(ZoneOffset.of("-03:00"))
                    ).sign(Algorithm.HMAC256("secreta"));
        
    }

}
