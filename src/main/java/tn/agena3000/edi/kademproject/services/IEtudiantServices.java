package tn.agena3000.edi.kademproject.services;

import tn.agena3000.edi.kademproject.entities.Etudiant;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IEtudiantServices {
    void ajouterEtudiant(Etudiant e);
    void updateEtudiant(Etudiant e);
    List<Etudiant> getAll();
    Etudiant getByID(Integer id);
    void deleteEtudiant(Integer id);
}
