package tn.agena3000.edi.kademproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.agena3000.edi.kademproject.entities.Departement;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    @Query("select u.departements from Universite u where u.nomUniv=?1")
    List<Departement> getAllDepartementsByNomUniv(String nomU);

    @Query(value = "select *" +
            "from departement d, universite u, universite_departements ud\n" +
            "where u.nom_univ ='Esprit' and d.id_depart = ud.departements_id_depart and u.id_univ = ud.universite_id_univ;", nativeQuery = true)
    List<Departement> getAllDepartementsByNomUnivSQL(String nomU);

    @Query("select d from Departement d order by size(d.etudiants) desc")
    List<Departement> getListDepartementTrierparEtudiant();

    @Query(value = "select *" +
            "from departement d\n" +
            "order by (select count(*) from etudiant e WHERE d.id_depart = e.departement_id_depart);", nativeQuery = true)
    List<Departement> getListDepartementTrierparEtudiantSQL();
}
