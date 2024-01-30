package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Entities.Variety;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*If your transformation logic involves complex mapping, requires customization for individual fields, or
needs to perform additional processing, a dedicated transformer class provides a clear place to
encapsulate this logic.*/
public class ProductTransformer {

    //    public static ProductDTO transformToDTO(Product product) {
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setName(product.getNomProduct());
//        productDTO.setDescription(product.getDescription());
//        productDTO.setPrixProduct(product.getPrixProduct());
//        productDTO.setCategoryID(product.getCategory().getIdCategory());
//        // Set other fields as needed
//        return productDTO;
//    }
    public static ProductDTO transformToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNomProduct(product.getNomProduct());
        productDTO.setIdProduct(product.getIdProduct());
        productDTO.setDescription(product.getDescription());
        productDTO.setReference(product.getReference());
        productDTO.setCategoryID(product.getCategory().getIdCategory());
        productDTO.setSupplierID(product.getSupplier().getIdSupplier());
        productDTO.setPrixProduct(product.getPrixProduct());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setImgs(product.getImgs());

        /*Set<Long> varietyIDs= new HashSet<>();
        for (Variety variety : product.getVarieties()) {
            varietyIDs.add(variety.getIdVariety());
        }*/
       productDTO.setVarietys(product.getVarieties());


        return productDTO;
    }

    // You can also create a method for transforming a list of products to a list of DTOs
    public static List<ProductDTO> transformListToDTOList(List<Product> productList) {
        return productList.stream()
                .map(ProductTransformer::transformToDTO)
                .collect(Collectors.toList());
    }

    public static Product transformToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setIdProduct(productDTO.getIdProduct());
        product.setNomProduct(productDTO.getNomProduct());
        product.setReference(productDTO.getReference());
        product.setDescription(productDTO.getDescription());
        product.setPrixProduct(productDTO.getPrixProduct());
        product.setQuantity(productDTO.getQuantity());
        product.setImgs(productDTO.getImgs());

        Category category = new Category();
        category.setIdCategory(productDTO.getCategoryID());
        product.setCategory(category);

        Supplier supplier = new Supplier();
        supplier.setIdSupplier(productDTO.getSupplierID());
        product.setSupplier(supplier);


        /*Set<Variety> varietys = new HashSet<>();

        for (Long varietyID : productDTO.getVarietyIDs()) {
            Variety variety = new Variety();
            variety.setIdVariety(varietyID);
            varietys.add(variety);
        }*/
        product.setVarieties(productDTO.getVarietys());



        //product.setSupplier();

        return product;
    }


    public static List<Product> transformListToEntityList(List<ProductDTO> productDTOList) {
        return productDTOList.stream()
                .map(ProductTransformer::transformToEntity)
                .collect(Collectors.toList());
    }

}
