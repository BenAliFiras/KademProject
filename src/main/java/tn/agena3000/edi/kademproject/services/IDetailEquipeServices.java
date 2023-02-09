package tn.agena3000.edi.kademproject.services;

import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeServices {
    void ajouterDetailEquipe(DetailEquipe de);
    void updateDetailEquipe(DetailEquipe de);
    List<DetailEquipe> getAll();
    DetailEquipe getByID(Integer id);
    void deleteDetailEquipe(Integer id);
}
