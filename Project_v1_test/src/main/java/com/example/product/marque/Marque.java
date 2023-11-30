package com.example.product.marque;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="marque")
public class Marque{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marqueid")
    private int marqueId;
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;
    @Column(name = "pays_origine")
    private String pays_origine;



    public Marque() {
    }
    public Marque(int marqueId, String nom, String description, String pays_origine) {
        this.marqueId = marqueId;
        this.nom = nom;
        this.description = description;
        this.pays_origine = pays_origine;
    }
    public int getMarqueId() {
        return marqueId;
    }
    public void setMarqueId(int marqueId) {
        this.marqueId = marqueId;
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
    public String getPays_origine() {
        return pays_origine;
    }
    public void setPays_origine(String pays_origine) {
        this.pays_origine = pays_origine;
    }
    @Override
    public String toString() {
        return "Marque [marqueId=" + marqueId + ", nom=" + nom + ", description=" + description + ", pays_origine="
                + pays_origine + "]";
    }
}