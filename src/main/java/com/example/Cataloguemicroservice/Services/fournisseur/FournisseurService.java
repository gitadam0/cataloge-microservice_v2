package com.example.Cataloguemicroservice.Services.fournisseur;

import com.example.Cataloguemicroservice.DTO.FournisseurDTO;
import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;

import java.util.List;

public interface FournisseurService {
    public Fournisseur findFournisseurByNom(String fournisseurName);

    FournisseurDTO createFournisseur(FournisseurDTO fournisseur) throws MyEntityNotFoundException;
    List<FournisseurDTO> createFournisseurs(List<FournisseurDTO> fournisseurs);
    FournisseurDTO updateFournisseur(Long id, FournisseurDTO fournisseur) throws MyEntityNotFoundException;
    void deleteFournisseur(Long id);
    FournisseurDTO getFournisseurById(Long id) throws MyEntityNotFoundException;
    List<Fournisseur> getFournisseurs();

    List<Fournisseur> getFournisseurProducts(long idFournisseur,long idProduct);


}
