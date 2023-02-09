package tn.agena3000.edi.kademproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.edi.kademproject.entities.Contrat;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.services.IContratServices;
import tn.agena3000.edi.kademproject.services.IDepartementServices;

import java.util.List;

@RestController
public class ContratController {

        @Autowired
        private IContratServices iContratServices;

        @GetMapping("/getAll")
        public List<Contrat> getAll(){
            return iContratServices.getAll();
        }
        @GetMapping("/getById/{id}")
        public Contrat getById(@PathVariable int id){
            return iContratServices.getByID(id);
        }
        @DeleteMapping("/deleteContrat/{id}")
        private void deleteContrat(@PathVariable int id){
            iContratServices.deleteContrat(id);
        }
        @PostMapping("/ajouterContrat")
        public void ajouterContrat(@RequestBody Contrat contrat){
            iContratServices.ajouterContrat(contrat);
        }
        @PutMapping("/updateContrat")
        private Contrat updateContrat(@RequestBody Contrat contrat){
            iContratServices.updateContrat(contrat);
            return contrat;
        }
}
