package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.DTO.FournisseurDTO;
import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Services.fournisseur.FournisseurService;
import com.example.Cataloguemicroservice.jms.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping
    public List<FournisseurDTO> getFournisseurs() {
        return fournisseurService.getFournisseurs();
    }

    @GetMapping("/{id}")
    public FournisseurDTO getFournisseurByID(@PathVariable Long id) throws MyEntityNotFoundException {
        return fournisseurService.getFournisseurById(id);
    }
    @GetMapping("getFournisseurByIDWithProducts./{id}")
    public Fournisseur getFournisseurByIDWithProducts(@PathVariable Long id) throws MyEntityNotFoundException {
        return fournisseurService.getFournisseurProducts(id);
    }
    @Autowired
    MessageSender messageSender;
    @PostMapping
    public FournisseurDTO createFournisseur(@RequestBody FournisseurDTO fournisseur) throws MyEntityNotFoundException {
        FournisseurDTO fournisseurDTO= fournisseurService.createFournisseur(fournisseur);
        messageSender.sendFournisseur(fournisseurDTO);
        return fournisseurDTO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFournisseur(@PathVariable Long id) {
        fournisseurService.deleteFournisseur(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public FournisseurDTO updateFournisseur(@PathVariable Long id, @RequestBody FournisseurDTO fournisseur) throws MyEntityNotFoundException {
        return fournisseurService.updateFournisseur(id, fournisseur);
    }
}
