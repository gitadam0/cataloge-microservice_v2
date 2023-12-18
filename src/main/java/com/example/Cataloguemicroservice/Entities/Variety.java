package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Varietys")
@NoArgsConstructor
public class Variety {
    @Id
    private Long idVariety;
    private String varietyName;

    @DBRef
    private List<Product> products;
}
