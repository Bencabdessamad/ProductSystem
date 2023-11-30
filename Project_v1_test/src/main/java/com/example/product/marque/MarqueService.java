package com.example.product.marque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    public Marque getMarqueById(int marqueId) {
        return marqueRepository.findById(marqueId).orElse(null);
    }

    public Marque createMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public Marque updateMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public void deleteMarque(int marqueId) {
        marqueRepository.deleteById(marqueId);
    }

    public List<Marque> rechercherMarquesParNom(String nom) {
           return marqueRepository.findByNom(nom);
       }
}
