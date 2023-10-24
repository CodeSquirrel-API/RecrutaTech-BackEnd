package br.gov.sp.fatec.recrutatech.Security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

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


    public String verificarToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secreta")).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject(); // Retorna o nome de usuário (username)
        } catch (JWTVerificationException exception) {
            // Token inválido ou expirado
            return null;
        }
    }
}
