package br.gov.sp.fatec.recrutatech.dto;

import java.util.List;

import br.gov.sp.fatec.recrutatech.enums.ExperienceType;

public class CandidateRequestDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String currentProfession;
    private ExperienceType experience;
    private List<Long> knowledgeList;
    private List<Long> skillsList;
    private List<Long> attitudeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCurrentProfession() {
        return currentProfession;
    }

    public void setCurrentProfession(String currentProfession) {
        this.currentProfession = currentProfession;
    }

    public ExperienceType getExperiences() {
        return experience;
    }

    public void setExperiences(ExperienceType experience) {
        this.experience = experience;
    }

    public List<Long> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<Long> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    public List<Long> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Long> skillsList) {
        this.skillsList = skillsList;
    }

    public List<Long> getAttitudeList() {
        return attitudeList;
    }

    public void setAttitudeList(List<Long> attitudeList) {
        this.attitudeList = attitudeList;
    }

}
