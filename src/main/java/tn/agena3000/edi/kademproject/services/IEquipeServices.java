package tn.agena3000.edi.kademproject.services;

import tn.agena3000.edi.kademproject.entities.Equipe;
import tn.agena3000.edi.kademproject.entities.Etudiant;

import java.util.List;

public interface IEquipeServices {
    void ajouterEquipe(Equipe e);
    void updateEquipe(Equipe e);
    List<Equipe> getAll();
    Equipe getByID(Integer id);
    void deleteEquipe(Integer id);
}
