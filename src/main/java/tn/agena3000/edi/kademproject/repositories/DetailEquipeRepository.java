package tn.agena3000.edi.kademproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.DetailEquipe;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe, Integer> {
}
