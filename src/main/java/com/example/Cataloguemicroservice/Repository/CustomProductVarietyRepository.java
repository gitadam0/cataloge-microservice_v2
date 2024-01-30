package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.CustomProductVariety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomProductVarietyRepository extends JpaRepository<CustomProductVariety, Long> {
}
