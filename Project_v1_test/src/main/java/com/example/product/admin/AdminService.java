package com.example.product.admin;

import java.util.List;

import com.example.product.categorie.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(int adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }


    public void deleteAdmin(int adminId) {
        adminRepository.deleteById(adminId);
    }

    public Admin login(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

    public List<Admin> rechercherAdminParNomOrPrenom(String nom, String prenom) {
        return adminRepository.findByNomOrPrenom(nom,prenom);
    }


}
