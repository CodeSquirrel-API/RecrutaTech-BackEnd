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

    @Column(name = "pst_cha")
    private String cha;
    
    @Column(name = "pst_experience")
    private ExperienceType experience;
    
    public Position(){
        
    } 

    public Position(String name, String cha, ExperienceType experience){
        this();
        this.name = name;
        this.cha = cha;
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

    public String getCha() {
        return cha;
    }

    public void setCha(String cha) {
        this.cha = cha;
    }

    public ExperienceType getExperience() {
        return experience;
    }

    public void setExperience(ExperienceType experience) {
        this.experience = experience;
    }


}
