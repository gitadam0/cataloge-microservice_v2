package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Fournisseur;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> getByProductsIn(List<Long> productIds);
    Fournisseur findByNomFournisseur(String nomFournisseur);
    Fournisseur findByIdFournisseur(long id) throws MyEntityNotFoundException;
    //Fournisseur findFournisseurWithProductsByIdFournisseur(long id);
    Optional<Fournisseur> findFournisseurWithProductsByIdFournisseur(long id);
}

