package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> getByProductsIn(List<Long> productIds);
    Fournisseur findByNomFournisseur(String nomFournisseur);
    Fournisseur findByIdFournisseur(long id);
}
