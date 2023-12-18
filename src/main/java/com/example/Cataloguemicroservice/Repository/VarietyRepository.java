package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Variety;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VarietyRepository extends MongoRepository<Variety, Long> {
    List<Variety> findAllByProductsEmpty();
}