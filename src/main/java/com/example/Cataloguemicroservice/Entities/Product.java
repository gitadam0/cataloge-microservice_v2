package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
@Document("Products")
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String nomProduct;
//    @Column(nullable = false)
    private String description;

    @Indexed(unique = true)
    private String reference;
    private double prixProduct;
    private Long quantity;


    @DBRef
    private Category category;

    @DBRef
    private Supplier supplier;

    @DBRef
    private List<Etiquette> etiquettes;

    @DBRef
    private List<Variety> varieties;

}
