package com.example.Cataloguemicroservice.DTO;

import com.example.Cataloguemicroservice.Entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    /*@NotBlank(message = "Product name is required")
    private String nomProduct;*/
    private Long idProduct;
    private String reference;
    private String nomProduct;
    private String description;
    private double prixProduct;
    private Long categoryID;
    private Long  supplierID;

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

