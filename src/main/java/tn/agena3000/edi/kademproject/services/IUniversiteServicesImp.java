package tn.agena3000.edi.kademproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.Specialite;
import tn.agena3000.edi.kademproject.entities.Universite;
import tn.agena3000.edi.kademproject.repositories.ContratRepository;
import tn.agena3000.edi.kademproject.repositories.DepartementRepository;
import tn.agena3000.edi.kademproject.repositories.UniversiteRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IUniversiteServicesImp implements IUniversiteServices{

    //@Autowired
    private final UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;
    private final ContratRepository contratRepository;
    @Override
    public void ajoutUniversite(Universite u) {
        universiteRepository.save(u);
    }

    @Override
    public void updateUniversite(Universite u) {
        universiteRepository.save(u);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getByIdUniversite(Integer id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUniversite(Integer id) {
        universiteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Assert.isNull(universite, "Entity must not be null.");
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Assert.isNull(departement, "Entity must not be null.");
        universite.getDepartements().add(departement);

        //2eme methode
        /*List<Departement> departements = universite.getDepartements();
        departements.add(departement);
        universite.setDepartements(departements);*/
        universiteRepository.save(universite);

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
