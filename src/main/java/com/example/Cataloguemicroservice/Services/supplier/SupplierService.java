package com.example.Cataloguemicroservice.Services.supplier;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.DTO.SupplierDTO;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;

import java.util.List;

public interface SupplierService {
    SupplierDTO findSupplierByNom(String supplierName);

    SupplierDTO createSupplier(SupplierDTO supplier) throws MyEntityNotFoundException;
    List<SupplierDTO> createSuppliersList(List<SupplierDTO> suppliers);
    Supplier updateSupplier(Long id, SupplierDTO supplier) throws MyEntityNotFoundException;
    void deleteSupplier(Long id);
    SupplierDTO getSupplierById(Long id) throws MyEntityNotFoundException;
    List<SupplierDTO> getSuppliers();

    List<ProductDTO> getSupplierProducts(long idSupplier) throws MyEntityNotFoundException;

}
