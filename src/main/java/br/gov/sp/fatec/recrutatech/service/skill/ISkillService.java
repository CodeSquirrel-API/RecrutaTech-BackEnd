package br.gov.sp.fatec.recrutatech.service.skill;

import java.util.List;

import br.gov.sp.fatec.recrutatech.entity.Skill;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;

public interface ISkillService {

    public Skill findById(Long id);

    public List<Skill> getAllSkills();

    public List<Skill> addSkills(List<Skill> skills);

    public List<Skill> updateSkills(List<Skill> skills);

    public Skill deleteSkill(Long id);

    public List<Skill> getSkillByExperienceType(ExperienceType experience);

}
