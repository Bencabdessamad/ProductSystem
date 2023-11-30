package com.example.product.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    public Admin findByEmailAndPassword(String email, String password);
    List<Admin> findByNomOrPrenom(String nom, String prenom);

}
