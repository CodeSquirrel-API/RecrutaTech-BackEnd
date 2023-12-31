package br.gov.sp.fatec.recrutatech.service.knowledge;

import java.util.List;


import br.gov.sp.fatec.recrutatech.entity.Knowledge;
import br.gov.sp.fatec.recrutatech.enums.ExperienceType;

public interface IKnowledgeService {

    public Knowledge findById(Long id);

    public List<Knowledge> getAllKnowledges();

    public List<Knowledge> addKnowledges(List<Knowledge> knowledges);

    public List<Knowledge> updateKnowledges(List<Knowledge> knowledges);

    public Knowledge deleteKnowledge(Long id);

    public List<Knowledge> getKnowledgesByExperienceType(ExperienceType experience);


}
