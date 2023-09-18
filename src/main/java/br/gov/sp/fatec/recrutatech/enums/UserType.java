package br.gov.sp.fatec.recrutatech.enums;

public enum UserType {
    INDIVIDUAL(0),
    COMPANY(1);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
