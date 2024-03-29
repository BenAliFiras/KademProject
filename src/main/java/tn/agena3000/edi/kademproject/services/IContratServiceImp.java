package tn.agena3000.edi.kademproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.repositories.ContratRepository;
import tn.agena3000.edi.kademproject.repositories.DepartementRepository;
import tn.agena3000.edi.kademproject.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public  class IContratServiceImp implements IContratServices{

    //@Autowired
    private final ContratRepository contratRepository;
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
            int ContratA = 0;
            ContratA = etudiant.getContrats().stream()
                    .filter(contrat -> contrat.getArchive().equals(true))
                    .collect(Collectors.toList())
                    .size();
            ContratA = contratRepository.countContratByArchiveIsTrueAndEtudiantIdEtudiant(etudiant.getIdEtudiant());
            if(ContratA<=5){
                ce.setEtudiant(etudiant);
            }
        }
        return contratRepository.save(ce);
    }

    @Override
    public Map<String, Float> getMontantContratEntreDeuxDate(Integer idUniv, LocalDate startDate, LocalDate endDate) {
        List<Contrat> contrats = new ArrayList<>();
        Map<String, Float> montantsParSpecialite = new HashMap<>();
        contrats.addAll(contratRepository.findAll());
        for (Contrat contrat : contrats) {
            String specialite = contrat.getSpecialite().name();
            float montant = montantsParSpecialite.getOrDefault(specialite, 0f);
            montant += contrat.getMontantContrat();
            montantsParSpecialite.put(specialite, montant);
        }
        return montantsParSpecialite;
    }

    @Override
    public Integer nbContratsValides(Date endDate, Date startDate) {
        return contratRepository.countContratByDateDebutContratAfterAndDateFinContratBefore(endDate,startDate);
    }

    @Override
    @Scheduled(cron = "*/30 * * * * * ")
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> contratsPresqueExp=contratRepository.datePresqueExp();
        List<Contrat> contratsExp=contratRepository.dateExpi();

        for (Contrat c : contratsExp) {
            setArchive(c);
        }

        StringBuilder string = new StringBuilder("contrats expirants dans les 15 jours suivants :");
        for (Contrat c : contratsPresqueExp){
            string.append("contrat id : ").append(c.getIdContrat()).append("\n");
            string.append("contrat debut date : ").append(c.getDateDebutContrat()).append("\n");
            string.append("contrat date fin : ").append(c.getDateFinContrat()).append("\n");
            string.append("specialité : ").append(c.getSpecialite()).append("\n");
        }
        log.info(string.toString());
    }

    public void setArchive(Contrat c){
        Contrat contrat = contratRepository.findById(c.getIdContrat()).get();
        contrat.setArchive(true);
        contratRepository.save(contrat);
    }
}
