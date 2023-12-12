package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.FournisseurDTO;
import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Entities.Product;

import java.util.List;

public class FournisseurTransformer {
    public static FournisseurDTO transformToDTO(Fournisseur fournisseur) {
        FournisseurDTO fournisseurDTO = new FournisseurDTO();
        fournisseurDTO.setIdFournisseur(fournisseur.getIdFournisseur());
        fournisseurDTO.setNomFournisseur(fournisseur.getNomFournisseur());
        return fournisseurDTO;
    }

    public static List<FournisseurDTO> transformToListOfDTO(List<Fournisseur> fournisseurs) {
        return fournisseurs.stream().map(FournisseurTransformer::transformToDTO).collect(java.util.stream.Collectors.toList());
    }

    public static Fournisseur transformToEntity(FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(fournisseurDTO.getIdFournisseur());
        fournisseur.setNomFournisseur(fournisseurDTO.getNomFournisseur());
        return fournisseur;
    }

    public static List<Fournisseur> transformToListOfEntity(List<FournisseurDTO> fournisseurDTOs) {
        return fournisseurDTOs.stream().map(FournisseurTransformer::transformToEntity).collect(java.util.stream.Collectors.toList());
    }
}
