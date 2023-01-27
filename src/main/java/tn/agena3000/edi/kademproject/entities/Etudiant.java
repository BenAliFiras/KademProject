package tn.agena3000.edi.kademproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Etudiant {
    @Id
    int idEtudiant;
    String prenomE;
    String nomE;
    Option option;
}
