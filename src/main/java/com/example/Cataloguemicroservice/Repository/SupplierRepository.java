package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends MongoRepository<Supplier, Long> {
    List<Supplier> getByProductsIn(List<Long> productIds);
    Supplier findByNomSupplier(String nomSupplier);
    Supplier findByIdSupplier(long id) throws MyEntityNotFoundException;
    //Supplier findSupplierWithProductsByIdSupplier(long id);
    Optional<Supplier> findSupplierWithProductsByIdSupplier(long id);
    List<Product> findProductsByIdSupplier(long idFournisseur);


}

