package com.example.Cataloguemicroservice.DTO;

import com.example.Cataloguemicroservice.Entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Data
@NoArgsConstructor
public class FournisseurDTO {

    private Long idFournisseur;
    private String nomFournisseur;

    public FournisseurDTO(Long idFournisseur,String nomFournisseur) {
        this.idFournisseur = idFournisseur;
        this.nomFournisseur = nomFournisseur;
    }

}

