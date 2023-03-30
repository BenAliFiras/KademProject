package tn.agena3000.edi.kademproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Etudiant;
import tn.agena3000.edi.kademproject.entities.Universite;
import tn.agena3000.edi.kademproject.repositories.UniversiteRepository;
import tn.agena3000.edi.kademproject.services.IUniversiteServices;

import java.util.List;

@Tag(name = "UniversiteC")
@RestController
@RequestMapping("universite")
@RequiredArgsConstructor
public class UniversiteController {

    //@Autowired
    private final IUniversiteServices iUniversiteServices;

    @GetMapping()
    public List<Universite> getAllUniversite(){
        return iUniversiteServices.getAllUniversite();
    }
    @GetMapping("/{id}")
    public Universite getByIdUniversite(@PathVariable int id){
        return iUniversiteServices.getByIdUniversite(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable int id){
        iUniversiteServices.deleteUniversite(id);
    }
    @PostMapping()
    public void ajoutUniversite(@RequestBody Universite universite){
        iUniversiteServices.ajoutUniversite(universite);
    }
    @PutMapping()
    public Universite updateUniversite(@RequestBody Universite universite){
        iUniversiteServices.updateUniversite(universite);
        return universite;
    }
    @PutMapping("{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite, @PathVariable Integer idDepartement) {
        iUniversiteServices.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
}
