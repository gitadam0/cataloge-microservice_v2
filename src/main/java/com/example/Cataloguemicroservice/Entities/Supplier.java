package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;
@Data
@Document("Suppliers")
@NoArgsConstructor
public class Supplier {
    @Id
    private Long idSupplier;
    private String nomSupplier;
    private String mail;
    private String rib;
    private String phoneNumber;

    @DBRef
    private List<Product> products;

}
