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

import java.util.List;

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
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE).orElse(null);
        Assert.notNull(etudiant,"Etudiant not find");
        Assert.notNull();
        if (etudiant == null || etudiant.getContrats().size() >= 5){

        }
        ce.setEtudiant(etudiant);
        return contratRepository.save(ce);
    }
}
