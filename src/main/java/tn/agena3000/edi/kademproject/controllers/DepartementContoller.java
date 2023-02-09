package tn.agena3000.edi.kademproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.Equipe;
import tn.agena3000.edi.kademproject.services.IDepartementServices;
import tn.agena3000.edi.kademproject.services.IEquipeServices;

import java.util.List;

@RestController
public class DepartementContoller{

    @Autowired
    private IDepartementServices iDepartementServices;

    @GetMapping("/getAll")
    public List<Departement> getAll(){
        return iDepartementServices.getAll();
    }
    @GetMapping("/getById/{id}")
    public Departement getById(@PathVariable int id){
        return iDepartementServices.getByID(id);
    }
    @DeleteMapping("/deleteDepartement/{id}")
    private void deleteDepartement(@PathVariable int id){
        iDepartementServices.deleteDepartement(id);
    }
    @PostMapping("/ajouterDepartement")
    public void ajouterDepartement(@RequestBody Departement departement){
        iDepartementServices.ajouterDepartement(departement);
    }
    @PutMapping("/updateDepartement")
    private Departement updateDepartement(@RequestBody Departement departement){
        iDepartementServices.updateDepartement(departement);
        return departement;
    }
}
