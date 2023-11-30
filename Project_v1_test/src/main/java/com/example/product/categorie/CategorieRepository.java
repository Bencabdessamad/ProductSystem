package com.example.product.categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
    List<Categorie> findByNom(String nom);
}
