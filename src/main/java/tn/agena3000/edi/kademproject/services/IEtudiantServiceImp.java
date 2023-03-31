package tn.agena3000.edi.kademproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.Equipe;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.repositories.ContratRepository;
import tn.agena3000.edi.kademproject.repositories.DepartementRepository;
import tn.agena3000.edi.kademproject.repositories.EquipeRepository;
import tn.agena3000.edi.kademproject.repositories.EtudiantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IEtudiantServiceImp implements IEtudiantServices {
    //@Autowired
    private final EtudiantRepository etudiantRepository;
    private final DepartementRepository departementRepository;
    private final ContratRepository contratRepository;
    private final EquipeRepository equipeRepository;
    @Override
    public void ajouterEtudiant(Etudiant e) {
        etudiantRepository.save(e);
    }

    @Override
    public void updateEtudiant(Etudiant e) {
        etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getByIdEtudiant(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);

        if ((etudiant != null) && (departement != null)){
            etudiant.setDepartement(departement);
            //departement.getEtudiants().add(etudiant);
            etudiantRepository.save(etudiant);
        }
    }

    @Override
    @Transactional //org.
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Assert.notNull(contrat, "Entity must not be null.");
        Assert.notNull(equipe, "Entity must not be null.");
        //ki yabda 3andi objet jdid mahouch jey ml bd na3mlou 3 ligne hedhom:
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        e.setEquipes(equipes);
        //5ater 3andich list
        etudiantRepository.saveAndFlush(e);
        e.getEquipes().add(equipe);
        contrat.setEtudiant(e);
        //contratRepository.save(contrat);
        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        //return etudiantRepository.findEtudiantByDepartement(idDepartement);
        //2éme méthode
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Assert.notNull(departement, "Entity must not be null.");
        return departement.getEtudiants();
    }
}
