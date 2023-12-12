package com.example.Cataloguemicroservice.Services.fournisseur;

import com.example.Cataloguemicroservice.DTO.FournisseurDTO;
import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Entities.Variety;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public Fournisseur findFournisseurByNom(String fournisseurName) {
        return null;
    }

    @Override
    public FournisseurDTO createFournisseur(FournisseurDTO fournisseur) {
        Objects.requireNonNull(fournisseur, "fournisseur cannot be null");

        Fournisseur fournisseurentity = FournisseurTransformer.transformToEntity(fournisseur);
        Objects.requireNonNull(fournisseurentity, "Entity transformation resulted in null");

        Fournisseur savedEntity = fournisseurRepository.save(fournisseurentity);
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

    }

    @Override
    public FournisseurDTO getFournisseurById(Long id) throws MyEntityNotFoundException {
        return null;
    }

    @Override
    public List<Fournisseur> getFournisseurs() {
        return null;
    }

    @Override
    public List<Fournisseur> getFournisseurProducts(long idFournisseur, long idProduct) {
        return null;
    }
}