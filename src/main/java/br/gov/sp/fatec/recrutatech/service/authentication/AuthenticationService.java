package br.gov.sp.fatec.recrutatech.service.authentication;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.User;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Override
    public Boolean sendEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'sendEmail'");
    }

    @Override
    public Boolean verifyCode(User user, String code) {
        throw new UnsupportedOperationException("Unimplemented method 'verifyCode'");
    }

}