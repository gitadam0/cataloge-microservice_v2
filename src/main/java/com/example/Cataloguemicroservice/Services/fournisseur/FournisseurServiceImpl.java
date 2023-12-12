package com.example.Cataloguemicroservice.Services.fournisseur;

import com.example.Cataloguemicroservice.DTO.FournisseurDTO;
import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.FournisseurRepository;
import com.example.Cataloguemicroservice.transformers.FournisseurTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {


    private final FournisseurRepository fournisseurRepository;

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
        fournisseurRepository.deleteById(id);
    }

    @Override
    public FournisseurDTO getFournisseurById(Long id) throws MyEntityNotFoundException {
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseur(id);
        Objects.requireNonNull(fournisseur, "fournisseur cannot be null");
        return FournisseurTransformer.transformToDTO(fournisseur);
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