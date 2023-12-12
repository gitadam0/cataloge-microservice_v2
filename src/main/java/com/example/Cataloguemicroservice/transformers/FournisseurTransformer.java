package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.FournisseurDTO;
import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Entities.Product;

public class FournisseurTransformer {
    public static FournisseurDTO transformToDTO(Fournisseur fournisseur) {
        FournisseurDTO fournisseurDTO = new FournisseurDTO();
        fournisseurDTO.setIdFournisseur(fournisseur.getIdFournisseur());
        fournisseurDTO.setNomFournisseur(fournisseur.getNomFournisseur());
        return fournisseurDTO;
    }

    public static Fournisseur transformToEntity(FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(fournisseurDTO.getIdFournisseur());
        fournisseur.setNomFournisseur(fournisseurDTO.getNomFournisseur());
        return fournisseur;
    }
}
