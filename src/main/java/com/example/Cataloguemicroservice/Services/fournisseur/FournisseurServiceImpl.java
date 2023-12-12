package com.example.Cataloguemicroservice.Services.fournisseur;

import com.example.Cataloguemicroservice.DTO.FournisseurDTO;
import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.EtiquetteRepository;
import com.example.Cataloguemicroservice.Repository.FournisseurRepository;
import com.example.Cataloguemicroservice.Repository.ProductRepository;
import com.example.Cataloguemicroservice.Repository.VarietyRepository;
import com.example.Cataloguemicroservice.Services.Category.CategoryService;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.transformers.FournisseurTransformer;
import com.example.Cataloguemicroservice.transformers.ProductTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Cataloguemicroservice.Repository.FournisseurRepository;
import com.example.Cataloguemicroservice.transformers.FournisseurTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {


    FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDTO findFournisseurByNom(String fournisseurName) {
        Fournisseur fournisseur = fournisseurRepository.findByNomFournisseur(fournisseurName);

        if (fournisseur != null) {
            return FournisseurTransformer.transformToDTO(fournisseur);
        } else {
            throw new EntityNotFoundException("Fournisseur not found");
        }
    }

    @Override
    public FournisseurDTO createFournisseur(FournisseurDTO fournisseur) {
        Objects.requireNonNull(fournisseur, "fournisseur cannot be null");

        Fournisseur fournisseurEntity = FournisseurTransformer.transformToEntity(fournisseur);
        Objects.requireNonNull(fournisseurEntity, "Entity transformation resulted in null");

        Fournisseur savedEntity = fournisseurRepository.save(fournisseurEntity);
        Objects.requireNonNull(savedEntity, "Saving the entity resulted in null");

        return FournisseurTransformer.transformToDTO(savedEntity);
    }


    @Override
    public List<FournisseurDTO> createFournisseursList(List<FournisseurDTO> fournisseurs) {
        return null;
    }

    @Override
    public FournisseurDTO updateFournisseur(Long id, FournisseurDTO fournisseur) throws MyEntityNotFoundException {
        return null;
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public FournisseurDTO getFournisseurById(Long id) throws MyEntityNotFoundException {
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseur(id);
        Objects.requireNonNull(fournisseur, "fournisseur cannot be null");
        return FournisseurTransformer.transformToDTO(fournisseur);
    }

    @Override
    public List<FournisseurDTO> getFournisseurs() {
        List<Fournisseur> listFournisseur = fournisseurRepository.findAll();

        if (listFournisseur != null) {
            return FournisseurTransformer.transformToListOfDTO(listFournisseur);
        } else {
            return Collections.emptyList(); // or throw new RuntimeException("Fournisseur list is null");
        }
    }

    @Override
    public Fournisseur getFournisseurProducts(long idFournisseur) throws MyEntityNotFoundException {
        return fournisseurRepository.findFournisseurWithProductsByIdFournisseur(idFournisseur)
                .orElseThrow(()->new MyEntityNotFoundException("fournisser not found for id "+idFournisseur));
    }


}