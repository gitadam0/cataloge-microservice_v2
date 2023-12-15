package com.example.Cataloguemicroservice.jms;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.DTO.StockProductDTO;
import com.example.Cataloguemicroservice.Services.MessagingService.YourMessagingService;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.Services.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class MessageConsumer {
    private final ProductService productService;


    public MessageConsumer(ProductService productService) {
        this.productService = productService;
    }
    @JmsListener(destination = "newStockArrived", containerFactory = "jmsListenerContainerFactory")
    public void receiveListProduct(String message) {
        System.out.println("Message reçu du topic : " + message);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<StockProductDTO> stockProductDTO = List.of(objectMapper.readValue(message, StockProductDTO[].class));

            for (StockProductDTO productDTO : stockProductDTO) {
                log.info("Reference: " + productDTO.getRef() + ", Quantity: " + productDTO.getQuantity());
                productService.updateProductStock(productDTO.getRef(),productDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            ObjectMapper objectMapper = new ObjectMapper();
            StockProductDTO[] productDTOs = objectMapper.readValue(message, StockProductDTO[].class);
            for (StockProductDTO productDTO : productDTOs) {
                productService.updateProductStock(productDTO.getReference(),productDTO);
                System.out.println("Reference: " + productDTO.getReference() + ", Quantity: " + productDTO.getQuantity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    /*@JmsListener(destination = "newStockArrived", containerFactory = "jmsListenerContainerFactory")
    public void receiveProduct(String message) {
        System.out.println("Message reçu du topic : " + message);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            stockProductDTO[] productDTOs = objectMapper.readValue(message, stockProductDTO[].class);
            for (ProductDTO productDTO : productDTOs) {
                productService.updateProduct(productDTO.getIdProduct());
                System.out.println("Reference: " + productDTO.getReference() + ", Quantity: " + productDTO.getQuantity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

}
