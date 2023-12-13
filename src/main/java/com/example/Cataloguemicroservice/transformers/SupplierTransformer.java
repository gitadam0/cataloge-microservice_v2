package com.example.Cataloguemicroservice.transformers;

import com.example.Cataloguemicroservice.DTO.SupplierDTO;
import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Entities.Product;

import java.util.List;

public class SupplierTransformer {
    public static SupplierDTO transformToDTO(Supplier fournisseur) {
        SupplierDTO fournisseurDTO = new SupplierDTO();
        fournisseurDTO.setIdSupplier(fournisseur.getIdSupplier());
        fournisseurDTO.setNomSupplier(fournisseur.getNomSupplier());
        return fournisseurDTO;
    }

    public static List<SupplierDTO> transformToListOfDTO(List<Supplier> fournisseurs) {
        return fournisseurs.stream().map(SupplierTransformer::transformToDTO).collect(java.util.stream.Collectors.toList());
    }

    public static Supplier transformToEntity(SupplierDTO fournisseurDTO) {
        Supplier fournisseur = new Supplier();
        fournisseur.setIdSupplier(fournisseurDTO.getIdSupplier());
        fournisseur.setNomSupplier(fournisseurDTO.getNomSupplier());
        return fournisseur;
    }

    public static List<Supplier> transformToListOfEntity(List<SupplierDTO> fournisseurDTOs) {
        return fournisseurDTOs.stream().map(SupplierTransformer::transformToEntity).collect(java.util.stream.Collectors.toList());
    }
}
