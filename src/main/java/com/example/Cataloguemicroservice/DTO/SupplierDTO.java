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
    private List<Product> products;
    public SupplierDTO(Long idFournisseur,String nomSupplier, List<Product> products) {
        this.idSupplier = idSupplier;
        this.nomSupplier = nomSupplier;
        this.products = products;
    }

}

