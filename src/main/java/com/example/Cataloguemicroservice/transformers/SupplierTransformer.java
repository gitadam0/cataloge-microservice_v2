package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.SupplierDTO;
import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Entities.Product;

import java.util.List;

public class SupplierTransformer {
    public static SupplierDTO transformToDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setIdSupplier(supplier.getIdSupplier());
        supplierDTO.setNomSupplier(supplier.getNomSupplier());
        supplierDTO.setRib(supplier.getRib());
        supplierDTO.setMail(supplier.getMail());
        supplierDTO.setPhoneNumber(supplier.getPhoneNumber());
        supplierDTO.setNomSupplier(supplier.getNomSupplier());
        supplierDTO.setProducts(supplier.getProducts());
        return supplierDTO;
    }

    public static List<SupplierDTO> transformToListOfDTO(List<Supplier> fournisseurs) {
        return fournisseurs.stream().map(SupplierTransformer::transformToDTO).collect(java.util.stream.Collectors.toList());
    }

    public static Supplier transformToEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setIdSupplier(supplierDTO.getIdSupplier());
        supplier.setNomSupplier(supplierDTO.getNomSupplier());
        supplier.setRib(supplierDTO.getRib());
        supplier.setMail(supplierDTO.getMail());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplier.setProducts(supplierDTO.getProducts());
        return supplier;
    }

    public static List<Supplier> transformToListOfEntity(List<SupplierDTO> fournisseurDTOs) {
        return fournisseurDTOs.stream().map(SupplierTransformer::transformToEntity).collect(java.util.stream.Collectors.toList());
    }
}
