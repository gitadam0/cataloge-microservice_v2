package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document("Etiquettes")
@NoArgsConstructor
public class Etiquette {
    @Id
    private Long idEtiquette;
    private String nomEtiquette;

    @DBRef
    private List<Product> products;
}
