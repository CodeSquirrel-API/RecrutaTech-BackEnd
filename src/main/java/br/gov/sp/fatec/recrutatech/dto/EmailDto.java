package br.gov.sp.fatec.recrutatech.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDto {

    @NotBlank
    @Email
    private String email;

    public EmailDto() {
    }


    public EmailDto(String email) {
        this.email=email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
