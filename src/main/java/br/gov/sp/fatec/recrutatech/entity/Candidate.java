package br.gov.sp.fatec.recrutatech.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

import br.gov.sp.fatec.recrutatech.enums.ExperienceType;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnd_id")
    private Long id;

    @Column(name = "cnd_name", unique = true)
    private String name;
 
    @Column(name = "cnd_email")
    private String email;

    @Column(name = "cnd_age")
    private Integer age;

    @Column(name = "cnd_current_profession")
    private String currentProfession;

    @Column(name = "cnd_experience")
    private ExperienceType experience;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_knowledge", joinColumns = @JoinColumn(name = "cnd_id"), inverseJoinColumns = @JoinColumn(name = "knw_id"))
    private List<Knowledge> knowledgeList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_skill", joinColumns = @JoinColumn(name = "cnd_id"), inverseJoinColumns = @JoinColumn(name = "knw_id"))
    private List<Skill> skillsList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidate_attitude", joinColumns = @JoinColumn(name = "cnd_id"), inverseJoinColumns = @JoinColumn(name = "knw_id"))
    private List<Attitude> attitudeList;

    public Candidate() {
    }

    public Candidate(String name, Integer age, String currentProfession, String currentCompany, ExperienceType experience,
            List<Knowledge> knowledgeList, List<Skill> skillsList, List<Attitude> attitudeList, String email) {
        this.name = name;
        this.age = age;
        this.currentProfession = currentProfession;
        this.experience = experience;
        this.knowledgeList = knowledgeList;
        this.skillsList = skillsList;
        this.attitudeList = attitudeList;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ExperienceType getExperiences() {
        return experience;
    }

    public void setExperiences(ExperienceType experience) {
        this.experience = experience;
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
