package br.gov.sp.fatec.recrutatech.service.skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.Skill;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;
import br.gov.sp.fatec.recrutatech.repository.SkillRepository;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skillRepo;

    public Skill findById(Long id) {
        Optional<Skill> skillOp = skillRepo.findById(id);

        return skillOp.orElse(null);
    }

    public List<Skill> getAllSkills() {
        return skillRepo.findAll();
    }

    public List<Skill> addSkills(List<Skill> skills) {
        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("Lista de habilidades vazia ou nula.");
        }

        return skillRepo.saveAll(skills);
    }

    public List<Skill> updateSkills(List<Skill> skills) {
        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("Lista de habilidades vazia ou nula.");
        }

        return skillRepo.saveAll(skills);
    }

    public Skill deleteSkill(Long id) {
        Optional<Skill> skillOp = skillRepo.findById(id);

        if (skillOp.isPresent()) {
            skillRepo.deleteById(id);
            return skillOp.get();
        } else {
            throw new IllegalArgumentException("ID de habilidade inválido");
        }
    }

    public List<Skill> getSkillByExperienceType(ExperienceType experienceType) {
        List<Skill> result = new ArrayList<>();

        // Itera sobre todos os conhecimentos
        for (Skill Skill : skillRepo.findAll()) {
            if (Skill.getExperience().equals(experienceType)) {
                result.add(Skill);
            }
        }

        return result;
    }
}
