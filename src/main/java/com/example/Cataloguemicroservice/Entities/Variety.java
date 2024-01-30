package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "varieties")
@NoArgsConstructor
public class Variety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVariety;
    private String varietyName;
    private String varietyValue;
    private Long quantity;
    @JsonIgnore
    @ManyToMany(mappedBy = "varieties")
   private List<Product> products;
   /*@OneToMany(mappedBy = "variety")
    private List<CustomProductVariety> products;*/
}
