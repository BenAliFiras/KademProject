package tn.agena3000.edi.kademproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.DetailEquipe;
import tn.agena3000.edi.kademproject.services.IDepartementServices;
import tn.agena3000.edi.kademproject.services.IDetailEquipeServices;

import java.util.List;

@Tag(name = "DetailEquipeC")
@RestController
@RequestMapping("detailEquipe")
@RequiredArgsConstructor
public class DetailEquipeController{

    //@Autowired
    private final IDetailEquipeServices iDetailEquipeServices;

    @GetMapping()
    public List<DetailEquipe> getAllDetailEquipe(){
        return iDetailEquipeServices.getAllDetailEquipe();
    }
    @GetMapping("/{id}")
    public DetailEquipe getByIdDetailEquipe(@PathVariable int id){
        return iDetailEquipeServices.getByIdDetailEquipe(id);
    }
    @DeleteMapping("/{id}")
    private void deleteDetailEquipe(@PathVariable int id){
        iDetailEquipeServices.deleteDetailEquipe(id);
    }
    @PostMapping()
    public void ajouterDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        iDetailEquipeServices.ajouterDetailEquipe(detailEquipe);
    }
    @PutMapping()
    private DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        iDetailEquipeServices.updateDetailEquipe(detailEquipe);
        return detailEquipe;
    }
}
