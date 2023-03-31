package tn.agena3000.edi.kademproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.Departement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    @Query("select count(c) from Contrat c where c.archive = false and c.etudiant.nomE = ?1 and c.etudiant.prenomE = ?2")
    Integer countContratByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nom, String Prenom);

    @Query("select count(c) from Contrat c where c.archive = true and c.etudiant.idEtudiant = ?1")
    Integer countContratByArchiveIsTrueAndEtudiantIdEtudiant(Integer idEtudiant);

    @Query("select c from Contrat c where DATEDIFF(current_date,c.dateFinContrat)<15")
    List<Contrat> dateExpi();

    @Query("select c from Contrat c where DATEDIFF(current_date,c.dateFinContrat)<15 AND current_date < c.dateFinContrat")
    List<Contrat> datePresqueExp();

    @Query("select count(c) from Contrat c where c.dateDebutContrat > ?1 and c.dateFinContrat < ?2")
    Integer countContratByDateDebutContratAfterAndDateFinContratBefore(Date endDate, Date startDate);
}