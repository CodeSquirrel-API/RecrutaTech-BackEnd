package br.gov.sp.fatec.recrutatech.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class messageDto {

    @NotBlank
    private String owner;

    @NotBlank
    @Email
    private String from;

    @NotBlank
    @Email
    private String to;

    @NotBlank
    private String title;

    @NotBlank
    private String text;
}