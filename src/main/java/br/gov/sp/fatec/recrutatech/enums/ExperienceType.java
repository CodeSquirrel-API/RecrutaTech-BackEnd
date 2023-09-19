package br.gov.sp.fatec.recrutatech.enums;

public enum ExperienceType {
    JUNIOR(0),
    Pleno(1),
    Senior(2);

    private final int value;

    ExperienceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
