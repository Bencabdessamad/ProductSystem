package com.example.product.piece;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="piece")
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pieceid")
    private int pieceId;
    @Column(name = "nom")
    private String nom;
    @Column(name = "marque")
    private String marque;
    @Column(name="categorie")
    private String categorie;
    @Column(name = "description")
    private String description;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "prix_achat")
    private double prix_achat;
    @Column(name = "prix_vente")
    private double prix_vente;


    public Piece() {}
    public Piece(int pieceId, String nom,String marque,String categorie, String description, int quantite, double prix_achat, double prix_vente) {
        this.pieceId = pieceId;
        this.nom = nom;
        this.marque=marque;
        this.categorie=categorie;
        this.description = description;
        this.quantite = quantite;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
    }
    public int getPieceId() {
        return pieceId;
    }

    public void setPieceId(int pieceId) {
        this.pieceId = pieceId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque(){
        return marque;
    }
    public void setMarque(String marque){
        this.marque=marque;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

}

