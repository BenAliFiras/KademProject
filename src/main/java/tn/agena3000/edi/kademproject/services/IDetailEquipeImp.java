package tn.agena3000.edi.kademproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.agena3000.edi.kademproject.entities.Departement;
import tn.agena3000.edi.kademproject.entities.DetailEquipe;
import tn.agena3000.edi.kademproject.repositories.DepartementRepository;
import tn.agena3000.edi.kademproject.repositories.DetailEquipeRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IDetailEquipeImp implements IDetailEquipeServices{

    //@Autowired
    private final DetailEquipeRepository detailEquipeRepository;
    @Override
    public void ajouterDetailEquipe(DetailEquipe de) {
        detailEquipeRepository.save(de);
    }

    @Override
    public void updateDetailEquipe(DetailEquipe de) {
        detailEquipeRepository.save(de);
    }

    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe getByIdDetailEquipe(Integer id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDetailEquipe(Integer id) {
        detailEquipeRepository.deleteById(id);
    }
}
