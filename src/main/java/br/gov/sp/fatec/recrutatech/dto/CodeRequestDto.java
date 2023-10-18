package br.gov.sp.fatec.recrutatech.dto;

public class CodeRequestDto {
    private String email;
    private Integer code;

    public Integer getCode() {
        return code;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
