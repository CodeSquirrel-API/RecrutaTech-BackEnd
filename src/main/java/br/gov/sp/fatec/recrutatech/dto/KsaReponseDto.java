package br.gov.sp.fatec.recrutatech.dto;

import java.util.ArrayList;
import java.util.List;

public class KsaReponseDto {

    private List<Long> skills;
    private List<Long> knowledges;
    private List<Long> attitudes;

      public KsaReponseDto() {
        this.skills = new ArrayList<>();
        this.knowledges = new ArrayList<>();
        this.attitudes = new ArrayList<>();
    }

    public List<Long> getSkills() {
        return skills;
    }

    public void setSkills(List<Long> skills) {
        this.skills = skills;
    }

    public List<Long> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(List<Long> knowledges) {
        this.knowledges = knowledges;
    }

    public List<Long> getAttitudes() {
        return attitudes;
    }

    public void setAttitudes(List<Long> attitudes) {
        this.attitudes = attitudes;
    }
}
