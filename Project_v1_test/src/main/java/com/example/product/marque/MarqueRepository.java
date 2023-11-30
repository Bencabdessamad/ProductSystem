package com.example.product.marque;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarqueRepository extends JpaRepository<Marque,Integer> {
    List<Marque> findByNom(String nom);
}