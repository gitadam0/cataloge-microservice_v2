package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Categorys")
@NoArgsConstructor
public class Category {
    @Id
    private Long idCategory;
//    @Column(nullable = true)
    private String nomCategory;


    @DBRef
    private List<Product> products;

}
