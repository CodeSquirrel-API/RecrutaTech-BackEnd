package br.gov.sp.fatec.recrutatech.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnd_id")
    private Long id;

    @Column(name = "cnd_name")
    private String name;

    @Column(name = "cnd_age")
    private Integer age;

    @Column(name = "cnd_current_profession")
    private String currentProfession;

    @Column(name = "cnd_experiences")
    private String experiences;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Knowledge> knowledgeList;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Skill> skillsList;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Attitude> attitudeList;

    public Candidate() {
    }

    public Candidate(String name, Integer age, String currentProfession, String currentCompany, String experiences,
            List<Knowledge> knowledgeList, List<Skill> skillsList, List<Attitude> attitudeList) {
        this.name = name;
        this.age = age;
        this.currentProfession = currentProfession;
        this.experiences = experiences;
        this.knowledgeList = knowledgeList;
        this.skillsList = skillsList;
        this.attitudeList = attitudeList;
    }

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

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public List<Knowledge> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<Knowledge> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    public List<Skill> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skill> skillsList) {
        this.skillsList = skillsList;
    }

    public List<Attitude> getAttitudeList() {
        return attitudeList;
    }

    public void setAttitudeList(List<Attitude> attitudeList) {
        this.attitudeList = attitudeList;
    }

}
