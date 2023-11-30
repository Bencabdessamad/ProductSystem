package com.example.product.categorie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategoryById(int categorieId) {
        return categorieRepository.findById(categorieId).orElse(null);
    }

    public Categorie createCategory(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategory(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void deleteCategory(int categorieId) {
        categorieRepository.deleteById(categorieId);
    }

    public List<Categorie> rechercherCategoriesParNom(String nom) {
              return categorieRepository.findByNom(nom);
          }
}
