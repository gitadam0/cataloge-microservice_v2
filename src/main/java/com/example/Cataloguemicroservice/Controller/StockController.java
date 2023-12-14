package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.DTO.StockProductDTO;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Services.MessagingService.YourMessagingService;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.jms.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final ProductService productService;

    @Autowired
    private YourMessagingService messagingService;


    public StockController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    MessageSender messageSender;



    @PostMapping("/sendProductfromStock")
    public StockProductDTO sendProductfromStock(@RequestBody StockProductDTO stockProduct) throws MyEntityNotFoundException {

        messageSender.sendProductfromstocktest(stockProduct);
        return stockProduct;
    }

}
