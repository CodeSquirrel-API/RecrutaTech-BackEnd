package br.gov.sp.fatec.recrutatech.service.knowledge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.recrutatech.entity.Knowledge;
import br.gov.sp.fatec.recrutatech.repository.KnowledgeRepository;

@Service
public class KnowledgeService implements IKnowledgeService {

    @Autowired
    private KnowledgeRepository knowledgeRepo;

    public Knowledge findById(Long id) {
        Optional<Knowledge> skillOp = knowledgeRepo.findById(id);

        return skillOp.orElse(null);
    }

    public List<Knowledge> getAllKnowledges() {
        return knowledgeRepo.findAll();
    }

    public List<Knowledge> addKnowledges(List<Knowledge> knowledges) {
        if (knowledges == null || knowledges.isEmpty()) {
            throw new IllegalArgumentException("Lista de atitudes vazia ou nula.");
        }

        return knowledgeRepo.saveAll(knowledges);
    }

    public List<Knowledge> updateKnowledges(List<Knowledge> knowledges) {
        if (knowledges == null || knowledges.isEmpty()) {
            throw new IllegalArgumentException("Lista de atitudes vazia ou nula.");
        }

        return knowledgeRepo.saveAll(knowledges);
    }

    public Knowledge deleteKnowledge(Long id) {
        Optional<Knowledge> knowledgeOp = knowledgeRepo.findById(id);

        if (knowledgeOp.isPresent()) {
            knowledgeRepo.deleteById(id);
            return knowledgeOp.get();
        } else {
            throw new IllegalArgumentException("ID de atitudes inválido");
        }
    }
}
