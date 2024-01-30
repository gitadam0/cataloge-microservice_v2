package com.example.Cataloguemicroservice.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class ProductVarietyKey implements Serializable {

    @Column(name = "product_id")
    Long productId;

    @Column(name = "variety_id")
    Long varietyId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}