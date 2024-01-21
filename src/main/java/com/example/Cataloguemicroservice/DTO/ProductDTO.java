package com.example.Cataloguemicroservice.DTO;

import com.example.Cataloguemicroservice.Entities.Product;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    /*@NotBlank(message = "Product name is required")
    private String nomProduct;*/
    private Long idProduct;
    private String reference;
    @JsonProperty( "name")
    @JsonAlias("name")
    private String nomProduct;
    private String description;
    private double prixProduct;
    private Long categoryID;
    private Long  supplierID;
    private Set<Long> varietyIDs;
    private Long quantity;

    public ProductDTO(Long idProduct,String name,String reference, String description, double prixProduct, Long categoryID) {
        this.idProduct = idProduct;
        this.nomProduct = name;
        this.reference = reference;
        this.description = description;
        this.prixProduct = prixProduct;
        this.categoryID = categoryID;
    }
/*
 If your transformation logic is straightforward, involves simple field mapping, and doesn't require
  extensive customization, constructor-based initialization provides a concise and readable way to create
   DTOs.*/
 /*   public ProductDTO(Product product) {
        this.name = product.getNomProduct();
        this.description = product.getDescription();
    }
*/

}

