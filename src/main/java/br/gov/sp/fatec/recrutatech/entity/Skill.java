package br.gov.sp.fatec.recrutatech.entity;

import java.util.List;

import br.gov.sp.fatec.recrutatech.enums.ExperienceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "skl_skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skl_id")
    private Long id;

    @Size(max = 64)
    @Column(unique = true, name = "skl_name")
    private String name;

    @Size(max = 255)
    @Column(name = "skl_description")
    private String description;

    @ManyToMany(mappedBy = "skillsList")
    private List<Candidate> candidates;

    @Column(name = "skl_experience")
    private ExperienceType experience;

    public ExperienceType getExperience() {
        return experience;
    }

    public void setExperience(ExperienceType experience) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
