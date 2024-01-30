package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.CustomProductVariety;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.CustomProductVarietyRepository;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.Services.Variety.VarietyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CustomProductVarietyController")
public class CustomProductVarietyController {

    private final CustomProductVarietyRepository customProductVarietyRepository;
    private final ProductService productService;
    private final VarietyService varietyService;


    public CustomProductVarietyController(CustomProductVarietyRepository customProductVarietyRepository, ProductService productService, VarietyService varietyService) {
        this.customProductVarietyRepository = customProductVarietyRepository;
        this.productService = productService;
        this.varietyService = varietyService;
    }

 /*   @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) throws MyEntityNotFoundException {
        return customProductVarietyRepository.getProductById(id);
    }
*/
    @GetMapping
 public List<CustomProductVariety> getAllProductVarietys() {
     return customProductVarietyRepository.findAll();
 }

    @PostMapping
    public CustomProductVariety createProduct(@RequestBody CustomProductVariety customProductVariety) throws MyEntityNotFoundException {

        return customProductVarietyRepository.save(customProductVariety);
    }




}
