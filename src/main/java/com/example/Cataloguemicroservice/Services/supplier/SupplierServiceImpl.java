package com.example.Cataloguemicroservice.Services.supplier;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.DTO.SupplierDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.transformers.ProductTransformer;
import com.example.Cataloguemicroservice.transformers.SupplierTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Cataloguemicroservice.Repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {


    SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDTO findSupplierByNom(String supplierName) {
        Supplier supplier = supplierRepository.findByNomSupplier(supplierName);

        if (supplier != null) {
            return SupplierTransformer.transformToDTO(supplier);
        } else {
            throw new EntityNotFoundException("Supplier not found");
        }
    }

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplier) {
        Objects.requireNonNull(supplier, "supplier cannot be null");

        Supplier supplierEntity = SupplierTransformer.transformToEntity(supplier);
        Objects.requireNonNull(supplierEntity, "Entity transformation resulted in null");

        Supplier savedEntity = supplierRepository.save(supplierEntity);
        Objects.requireNonNull(savedEntity, "Saving the entity resulted in null");

        return SupplierTransformer.transformToDTO(savedEntity);
    }


    @Override
    public List<SupplierDTO> createSuppliersList(List<SupplierDTO> suppliers) {
        return null;
    }

    @Override
    public Supplier updateSupplier(Long id, SupplierDTO supplier) throws MyEntityNotFoundException {
        Supplier existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException("Supplier not found with id: " + id));

        Supplier updatedSupplier = SupplierTransformer.transformToEntity(supplier);
        existingSupplier.setNomSupplier(updatedSupplier.getNomSupplier());
        existingSupplier.setMail(updatedSupplier.getMail());
        existingSupplier.setRib(updatedSupplier.getRib());
        existingSupplier.setPhoneNumber(updatedSupplier.getPhoneNumber());
        existingSupplier.setProducts(updatedSupplier.getProducts());
        supplierRepository.save(existingSupplier);
        return updatedSupplier;
    }

    @Override
    public void deleteSupplier(Long id) {
        /*Supplier defaultSupplier = null;
        try {
            defaultSupplier = supplierRepository.findById(1L)
                    .orElseThrow(()->new MyEntityNotFoundException(" default supplier not found for id:"+ 1
                            +"for this code to work you have to have a default supplier with id = 1"));
        } catch (MyEntityNotFoundException e) {
            throw new RuntimeException(e);
        }*/
        supplierRepository.deleteById(id);
    }

    @Override
    public SupplierDTO getSupplierById(Long id) throws MyEntityNotFoundException {
        Supplier supplier = supplierRepository.findByIdSupplier(id);
        Objects.requireNonNull(supplier, "supplier cannot be null");
        return SupplierTransformer.transformToDTO(supplier);
    }

    @Override
    public List<SupplierDTO> getSuppliers() {
        List<Supplier> listSupplier = supplierRepository.findAll();

        if (listSupplier != null) {
            return SupplierTransformer.transformToListOfDTO(listSupplier);
        } else {
            return Collections.emptyList(); // or throw new RuntimeException("Supplier list is null");
        }
    }

//    @Override
//    public Supplier getSupplierProducts(long idSupplier) throws MyEntityNotFoundException {
//        return supplierRepository.findSupplierWithProductsByIdSupplier(idSupplier)
//                .orElseThrow(()->new MyEntityNotFoundException("fournisser not found for id "+idSupplier));
//    }

    @Override
    public List<ProductDTO> getSupplierProducts(long idSupplier) {

        List<ProductDTO> listProducts = ProductTransformer.transformListToDTOList(supplierRepository.findProductsByIdSupplier(idSupplier));
        if (listProducts != null) {
            return listProducts;
        } else {
            return Collections.emptyList();
        }
    }
}