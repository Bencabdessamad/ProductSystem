package com.example.product.categorie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="categorie")
public class Categorie{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorieid")
    private int categorieId;
    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    public Categorie() {
    }

    public Categorie(int categorieId, String nom, String description) {
        this.categorieId = categorieId;
        this.nom = nom;
        this.description = description;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categorie [categorieId=" + categorieId + ", nom=" + nom + ", description=" + description + "]";
    }




}
