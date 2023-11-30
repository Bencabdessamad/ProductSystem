package com.example.product.admin;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private static Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AdminService adminService;

    // la methode pour get les admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        logger.debug("getAllAdmins()");
        return adminService.getAllAdmins();
    }
    // la methode pour get les admins
    @GetMapping("/{adminId}")
    public Admin getAdminById(@PathVariable int adminId) {logger.debug("getAdminById()");return adminService.getAdminById(adminId);
    }
    // la methode pour post un admin
    @PostMapping("/save")
    public Admin createAdmin(@RequestBody Admin admin) {
        logger.debug("createAdmin()");logger.debug(admin.toString());return adminService.createAdmin(admin);
    }
    // la methode pour modifier les admins
    @PutMapping("/update/{adminId}")
    public Admin updateAdmin(@PathVariable int adminId, @RequestBody Admin admin) {
        admin.setAdminId(adminId);
        logger.debug("updateAdmin()");logger.debug(admin.toString());
        return adminService.updateAdmin(admin);
    }
    // la methode pour supprimer les admins
    @DeleteMapping("/delete/{adminId}")
    public void deleteAdmin(@PathVariable int adminId) {
        logger.debug("deleteAdmin()");adminService.deleteAdmin(adminId);
    }

    // la methode pour login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        Admin admin = adminService.login(email, password);
        if (admin != null) {
            logger.debug("login()");
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.ok("Login failed");
        }
    }

    
    // la methode pour chercher un admin
    @GetMapping("/rechercherAdmin")
    public List<Admin> rechercherAdminParNomOrPrenom(@RequestParam String nom , @RequestParam String prenom) {
        return adminService.rechercherAdminParNomOrPrenom(nom,prenom);
    }

}
