package tn.agena3000.edi.kademproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Equipe;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.repositories.EtudiantRepository;
import tn.agena3000.edi.kademproject.services.IEtudiantServices;

import java.util.List;

@Tag(name = "EtudiantC")
@RestController
@RequestMapping("etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    //@Autowired
    private final IEtudiantServices iEtudiantServices;
    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }
    @GetMapping()
    public List<Etudiant> getAllEtudiant(){
        return iEtudiantServices.getAllEtudiant();
    }
    @GetMapping("getByIdEtudiant/{id}")
    public Etudiant getByIdEtudiant(@PathVariable int id){
        return iEtudiantServices.getByIdEtudiant(id);
    }
    @DeleteMapping("/{id}")
    private void deleteEtudiant(@PathVariable int id){
        iEtudiantServices.deleteEtudiant(id);
    }
    @PostMapping()
    public void ajouterEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantServices.ajouterEtudiant(etudiant);
    }
    @PutMapping()
    private Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantServices.updateEtudiant(etudiant);
        return etudiant;
    }
    @PutMapping("{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement (@PathVariable Integer etudiantId, @PathVariable Integer departementId) {
        iEtudiantServices.assignEtudiantToDepartement(etudiantId,departementId);
    } ;
    @PostMapping("{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable Integer idContrat, @PathVariable Integer idEquipe) {
        return iEtudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable Integer idDepartement) {
        return iEtudiantServices.getEtudiantsByDepartement(idDepartement);
    }
}
