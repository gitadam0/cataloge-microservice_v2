package com.example.Cataloguemicroservice.DTO;

import com.example.Cataloguemicroservice.Entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String mail;
    private String rib;
    private String phoneNumber;
    private List<Product> products;
    public SupplierDTO(Long idSupplier,String nomSupplier, List<Product> products, String mail,String rib,String phoneNumber) {
        this.idSupplier = idSupplier;
        this.nomSupplier = nomSupplier;
        this.mail = mail;
        this.rib = rib;
        this.phoneNumber = phoneNumber;
        this.products = products;
    }

}

