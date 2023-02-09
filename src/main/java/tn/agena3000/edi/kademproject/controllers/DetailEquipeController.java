package tn.agena3000.edi.kademproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.DetailEquipe;
import tn.agena3000.edi.kademproject.services.IDepartementServices;
import tn.agena3000.edi.kademproject.services.IDetailEquipeServices;

import java.util.List;

@RestController
public class DetailEquipeController{

    @Autowired
    private IDetailEquipeServices iDetailEquipeServices;

    @GetMapping("/getAll")
    public List<DetailEquipe> getAll(){
        return iDetailEquipeServices.getAll();
    }
    @GetMapping("/getById/{id}")
    public DetailEquipe getById(@PathVariable int id){
        return iDetailEquipeServices.getByID(id);
    }
    @DeleteMapping("/deleteDetailEquipe/{id}")
    private void deleteDetailEquipe(@PathVariable int id){
        iDetailEquipeServices.deleteDetailEquipe(id);
    }
    @PostMapping("/ajouterDetailEquipe")
    public void ajouterDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        iDetailEquipeServices.ajouterDetailEquipe(detailEquipe);
    }
    @PutMapping("/updateDepartement")
    private DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        iDetailEquipeServices.updateDetailEquipe(detailEquipe);
        return detailEquipe;
    }
}
