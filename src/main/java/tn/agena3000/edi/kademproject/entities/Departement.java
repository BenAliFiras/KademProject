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
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idDepart;
    private String nomDepart;
    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiants;
}
