package tn.agena3000.edi.kademproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipe {
    @Id
    int idEquipe;
    String nomEquipe;
    Niveau niveau;

}
