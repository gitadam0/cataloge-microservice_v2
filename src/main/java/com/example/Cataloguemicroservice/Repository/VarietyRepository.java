package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Variety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VarietyRepository extends JpaRepository<Variety, Long> {
    List<Variety> findAllByProductsEmpty();
}