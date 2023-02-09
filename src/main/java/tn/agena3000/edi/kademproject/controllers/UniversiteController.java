package tn.agena3000.edi.kademproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.entities.Universite;
import tn.agena3000.edi.kademproject.repositories.UniversiteRepository;
import tn.agena3000.edi.kademproject.services.IUniversiteServices;

import java.util.List;

@RestController
public class UniversiteController {

    @Autowired
    private IUniversiteServices iUniversiteServices;

    @GetMapping("/getAll")
    public List<Universite> getAll(){
        return iUniversiteServices.getAll();
    }
    @GetMapping("/getById/{id}")
    public Universite getByID(@PathVariable int id){
        return iUniversiteServices.getByID(id);
    }
    @DeleteMapping("/DeleteUniversite/{id}")
    public void deleteUniversite(@PathVariable int id){
        iUniversiteServices.deleteUniversite(id);
    }
    @PostMapping("ajoutUniversite")
    public void ajoutUniversite(@RequestBody Universite universite){
        iUniversiteServices.ajoutUniversite(universite);
    }
    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite universite){
        iUniversiteServices.updateUniversite(universite);
        return universite;
    }
}
