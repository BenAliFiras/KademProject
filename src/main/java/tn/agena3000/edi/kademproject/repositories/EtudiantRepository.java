package tn.agena3000.edi.kademproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.agena3000.edi.kademproject.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    Etudiant findByNomEAndPrenomE(String nomE, String prenomE);

    //requete avec JPQL
    //peut import le nom de la methode c'est different au keyword
    //Index parameter
    @Query("select e from Etudiant e where e.nomE =?1 and e.prenomE =?2 ")
    Etudiant getEtudiantByNomPrenom(String nom, String prenom);

    //Named parametre
    @Query("select e from Etudiant e where e.nomE =:nom and e.prenomE =:prenom ")
    Etudiant getEtudiantByNomPrenom2(@Param("nom") String nom,@Param("prenom") String prenom);
}
