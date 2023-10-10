package br.gov.sp.fatec.recrutatech.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class emailDto {

    @NotBlank
    public String subject;

    @NotBlank
    @Email
    public String email;

    @NotBlank
    @Email
    public String content;
}
