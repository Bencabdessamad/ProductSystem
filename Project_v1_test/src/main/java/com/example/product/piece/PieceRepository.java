package com.example.product.piece;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PieceRepository extends JpaRepository<Piece, Integer> {
    List<Piece> findByNom(String nom);
}