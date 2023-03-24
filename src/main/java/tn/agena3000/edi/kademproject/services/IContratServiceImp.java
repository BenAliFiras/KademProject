package tn.agena3000.edi.kademproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.repositories.ContratRepository;
import tn.agena3000.edi.kademproject.repositories.DepartementRepository;
import tn.agena3000.edi.kademproject.repositories.EtudiantRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IContratServiceImp implements IContratServices{

    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public void ajouterContrat(Contrat c) {
        contratRepository.save(c);
    }

    @Override
    public void updateContrat(Contrat c) {
        contratRepository.save(c);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getByIdContrat(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        Assert.notNull(etudiant,"Etudiant not find");

        if (etudiant == null || etudiant.getContrats().size() >= 5){

        }
        ce.setEtudiant(etudiant);
        return contratRepository.save(ce);
    }

    @Override
    public Map<String, Float> getMontantContratEntreDeuxDate(Integer idUniversite, LocalDate startDate, LocalDate endDate) {
        List<Contrat> contrats = contratRepository.findByEtudiant_Departement_Universite_IdAndEstArchiveAndDateDebutGreaterThanEqualAndDateFinLessThanEqual(idUniversite, false, startDate, endDate);
        Map<String, Float> montantsParSpecialite = new HashMap<>();
        for (Contrat contrat : contrats) {
            String specialite = contrat.getSpecialite().name();
            float montant = montantsParSpecialite.getOrDefault(specialite, 0f);
            montant += contrat.getMontantContrat();
            montantsParSpecialite.put(specialite, montant);
        }
        return montantsParSpecialite;
    }
}
