package br.gov.sp.fatec.recrutatech.entity;

import br.gov.sp.fatec.recrutatech.enums.ExperienceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pst_position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pst_id")
    private Long id;

    @Column(name = "pst_name")
    private String name;

    @Column(name = "pst_knowledge", length = 1000)
    private String knowledge;

    @Column(name = "pst_skill", length = 1000)
    private String skill;

    @Column(name = "pst_attitude", length = 1000)
    private String attitude;

    @Column(name = "pst_experience")
    private ExperienceType experience;

    public Position() {

    }

    public Position(String name, String knowledge, String skill, String attitude, ExperienceType experience) {
        this.name = name;
        this.knowledge = knowledge;
        this.skill = skill;
        this.attitude = attitude;
        this.experience = experience;
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

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public ExperienceType getExperience() {
        return experience;
    }

    public void setExperience(ExperienceType experience) {
        this.experience = experience;
    }

}