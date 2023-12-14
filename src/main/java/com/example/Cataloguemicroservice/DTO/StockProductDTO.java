package com.example.Cataloguemicroservice.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockProductDTO {


    private String ref;
    private Long quantity;

    public StockProductDTO(String ref,Long quantity) {
        this.ref = ref;
        this.quantity = quantity;
    }

}

