package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String nomProduct;
//    @Column(nullable = false)
    private String description;
    //not working
    @Column(unique = true,nullable = false)
    private String reference;
    private double prixProduct;
    private Long quantity;

    @ManyToOne
    private Category category;

    @ManyToOne
//    @JsonIgnore
    private Supplier supplier;

    @ManyToMany
    @JoinTable(
            name = "product_etiquette",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "etiquette_id"))
    private Set<Etiquette> etiquettes;

    @ManyToMany
    @JoinTable(
            name = "product_variety",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "variety_id"))
    /*@OneToMany(mappedBy = "product")*/
    private Set<Variety> varieties;




    @ElementCollection
    private List<String> imgs ;
    /*@ElementCollection
    private List<String> colors ;*/

}
