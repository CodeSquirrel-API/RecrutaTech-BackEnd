package br.gov.sp.fatec.recrutatech.service.ksa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.dto.KsaReponseDto;
import br.gov.sp.fatec.recrutatech.entity.Attitude;
import br.gov.sp.fatec.recrutatech.entity.Knowledge;
import br.gov.sp.fatec.recrutatech.entity.Skill;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;
import br.gov.sp.fatec.recrutatech.service.attitude.AttitudesService;
import br.gov.sp.fatec.recrutatech.service.knowledge.KnowledgeService;
import br.gov.sp.fatec.recrutatech.service.skill.SkillService;

@Service
public class KsaService {

    @Autowired
    private AttitudesService attitudeRepo;

    @Autowired
    private SkillService skillRepo;

    @Autowired
    private KnowledgeService knowledgeRepo;

    public KsaReponseDto getKSAByExperienceType(ExperienceType experienceType) {
        KsaReponseDto result = new KsaReponseDto();

        List<Attitude> attitudes = attitudeRepo.getAttitudeByExperienceType(experienceType);
        List<Long> attitudeIds = new ArrayList<>();

        if (attitudes.size() > 0) {

            for (Attitude attitude : attitudes) {
                attitudeIds.add(attitude.getId());
            }
            result.getAttitudes().addAll(attitudeIds);
        }

        List<Knowledge> knowledges = knowledgeRepo.getKnowledgesByExperienceType(experienceType);
        List<Long> knowledgeIds = new ArrayList<>();

        if (knowledges.size() > 0) {

            for (Knowledge knowledge : knowledges) {
                knowledgeIds.add(knowledge.getId());
            }

            result.getKnowledges().addAll(attitudeIds);
        }

        List<Skill> skills = skillRepo.getSkillByExperienceType(experienceType);

        List<Long> skillId = new ArrayList<>();

        if (skills.size() > 0) {

            for (Skill attitude : skills) {
                skillId.add(attitude.getId());
            }
            
            result.getSkills().addAll(skillId);
        }

        return result;
    }

}
