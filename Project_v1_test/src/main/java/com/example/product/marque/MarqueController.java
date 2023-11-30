package com.example.product.marque;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marques")
public class MarqueController {

    private static Logger logger = LoggerFactory.getLogger(MarqueController.class);

    @Autowired
    private MarqueService marqueService;

    @GetMapping
    public List<Marque> getAllMarques() {
        logger.debug("getAllMarques()");return marqueService.getAllMarques();
    }

    @GetMapping("/{marqueId}")
    public Marque getMarqueById(@PathVariable int marqueId) {
        logger.debug("getMarqueById()");return marqueService.getMarqueById(marqueId);
    }

    @PostMapping("/save")
    public Marque createMarque(@RequestBody Marque marque) {
        logger.debug("createMarque()");logger.debug(marque.toString());return marqueService.createMarque(marque);
    }

    @PutMapping("/update/{marqueId}")
    public Marque updateMarque(@PathVariable int marqueId, @RequestBody Marque marque) {
        marque.setMarqueId(marqueId);
        logger.debug("updateMarque()");logger.debug(marque.toString());
        return marqueService.updateMarque(marque);
    }

    @DeleteMapping("/delete/{marqueId}")
    public void deleteMarque(@PathVariable int marqueId) {
        logger.debug("deleteMarque()");marqueService.deleteMarque(marqueId);
    }

    @GetMapping("/rechercherMarque")
    public List<Marque> rechercherMarquesParNom(@RequestParam String nom) {
        logger.debug("rechercherMarquesParNom()");
        return marqueService.rechercherMarquesParNom(nom);
    }
}

