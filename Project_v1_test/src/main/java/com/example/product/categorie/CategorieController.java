package com.example.product.categorie;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    private static Logger logger = LoggerFactory.getLogger(CategorieController.class);
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getAllCategories() {
        logger.debug("getAllCategories()");return categorieService.getAllCategories();
    }

    @GetMapping("/{categorieId}")
    public Categorie getCategoryById(@PathVariable int categorieId) {
        logger.debug("getCategoryById()");
        return categorieService.getCategoryById(categorieId);
    }

    @PostMapping("/save")
    public Categorie createCategory(@RequestBody Categorie categorie) {
        logger.debug("createCategory()"); logger.debug(categorie.toString());
        return categorieService.createCategory(categorie);
    }

    @PutMapping("/update/{categorieId}")
    public Categorie updateCategory(@PathVariable int categorieId, @RequestBody Categorie categorie) {
        categorie.setCategorieId(categorieId);
        logger.debug("updateCategory()"); logger.debug(categorie.toString());
        return categorieService.updateCategory(categorie);
    }

    @DeleteMapping("/delete/{categorieId}")
    public void deleteCategory(@PathVariable int categorieId) {logger.debug("deleteCategory()");
        categorieService.deleteCategory(categorieId);
    }

        @GetMapping("/rechercherCategorie")
        public List<Categorie> rechercherCategoriesParNom(@RequestParam String nom) {
            logger.debug("rechercherCategoriesParNom()");
        return categorieService.rechercherCategoriesParNom(nom);
        }
}

