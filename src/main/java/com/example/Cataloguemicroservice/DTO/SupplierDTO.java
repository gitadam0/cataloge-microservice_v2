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
public class SupplierDTO {

    private Long idSupplier;
    private String nomSupplier;

    public SupplierDTO(Long idFournisseur,String nomSupplier) {
        this.idSupplier = idSupplier;
        this.nomSupplier = nomSupplier;
    }

}

