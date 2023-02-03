package tn.agena3000.edi.kademproject.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    private Departement departement;
    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;
    @ManyToMany(mappedBy = "etudiants")
    private List<Equipe> equipes;
}
