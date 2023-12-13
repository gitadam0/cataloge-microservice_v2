package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> getByProductsIn(List<Long> productIds);
    Supplier findByNomSupplier(String nomSupplier);
    Supplier findByIdSupplier(long id) throws MyEntityNotFoundException;
    //Supplier findSupplierWithProductsByIdSupplier(long id);
    Optional<Supplier> findSupplierWithProductsByIdSupplier(long id);
}

