package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product_variety")
@NoArgsConstructor
public class CustomProductVariety {

    @EmbeddedId
    ProductVarietyKey id;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;*/


    private Long price;
}
