package br.gov.sp.fatec.recrutatech.service.authentication;

import br.gov.sp.fatec.recrutatech.entity.User;

public interface IAuthenticationService {
    
    public Boolean sendEmail(String email);

    public Boolean verifyCode(User user, String code);
}
