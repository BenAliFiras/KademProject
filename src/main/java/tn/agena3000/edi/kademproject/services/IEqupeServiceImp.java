package tn.agena3000.edi.kademproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.Equipe;
import tn.agena3000.edi.kademproject.entities.Niveau;
import tn.agena3000.edi.kademproject.repositories.ContratRepository;
import tn.agena3000.edi.kademproject.repositories.EquipeRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IEqupeServiceImp implements IEquipeServices{
    //@Autowired
    private final EquipeRepository equipeRepository;
    private final ContratRepository contratRepository;
    @Override
    public void ajouterEquipe(Equipe e) {
        equipeRepository.save(e);
    }

    @Override
    public void updateEquipe(Equipe e) {
        equipeRepository.save(e);
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getByIdEquipe(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);
    }

    @Override
    @Scheduled(cron = "* * * 12 * *")
    public void faireEvoluerEquipes() {
        List<Equipe> equipes = equipeRepository.findAll();
        for (Equipe e : equipes) {
            if (e.getEtudiants().size()>=3 && e.getNiveau() == Niveau.JUNIOR) {
                e.setNiveau(Niveau.SENIOR);
                equipeRepository.save(e);
            } else if (e.getEtudiants().size()>=3 && e.getNiveau() == Niveau.SENIOR) {
                e.setNiveau(Niveau.EXPERT);
                equipeRepository.save(e);
            }
        }
    }
}
