package tn.agena3000.edi.kademproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.agena3000.edi.kademproject.entities.Equipe;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.entities.Option;
import tn.agena3000.edi.kademproject.entities.Specialite;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    List<Equipe> findByEtudiantsOptionAndEtudiantsContratsSpecialite(Option op, Specialite sp);
}
