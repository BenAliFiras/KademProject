package tn.agena3000.edi.kademproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Contrat {
    @Id
    int idContrat;
    Date dateDebutContrat;
    Date dateFinContrat;
    Specialite specialite;
    Boolean archive;
    int montantContrat;
}
