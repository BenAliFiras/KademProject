package tn.agena3000.edi.kademproject.services;

import tn.agena3000.edi.kademproject.entities.Universite;

import java.util.List;

public interface IUniversiteServices {

    void ajoutUniversite(Universite u);
    void updateUniversite(Universite u);
    List<Universite> getAll();
    Universite getByID(Integer id);
    void deleteUniversite(Integer id);
}
