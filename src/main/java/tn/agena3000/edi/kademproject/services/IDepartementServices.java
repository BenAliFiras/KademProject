package tn.agena3000.edi.kademproject.services;

import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.Equipe;

import java.util.List;

public interface IDepartementServices {
    void ajouterDepartement(Departement d);
    void updateDepartement(Departement d);
    List<Departement> getAllDepartement();
    Departement getByIdDepartement(Integer id);
    void deleteDepartement(Integer id);
}
