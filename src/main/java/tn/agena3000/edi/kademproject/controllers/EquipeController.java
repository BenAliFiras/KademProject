package tn.agena3000.edi.kademproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Equipe;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.services.IEquipeServices;

import java.util.List;

@RestController
public class EquipeController {

    @Autowired
    IEquipeServices iEquipeServices;
    @GetMapping("/getAll")
    public List<Equipe> getAll(){
        return iEquipeServices.getAll();
    }
    @GetMapping("/getById/{id}")
    public Equipe getById(@PathVariable int id){
        return iEquipeServices.getByID(id);
    }
    @DeleteMapping("/deleteEquipe/{id}")
    private void deleteEquipe(@PathVariable int id){
        iEquipeServices.deleteEquipe(id);
    }
    @PostMapping("/ajouterEtudiant")
    public void ajouterEquipe(@RequestBody Equipe equipe){
        iEquipeServices.ajouterEquipe(equipe);
    }
    @PutMapping("/updateEquipe")
    private Equipe updateEquipe(@RequestBody Equipe equipe){
        iEquipeServices.updateEquipe(equipe);
        return equipe;
    }
}
