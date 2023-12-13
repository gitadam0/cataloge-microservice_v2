package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
@Entity
@Data
@Table(name = "SupplierS")
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupplier;
    private String nomSupplier;
    private String mail;
    private String rib;
    private String phoneNumber;

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Product> products;

}
