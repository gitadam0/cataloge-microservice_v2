package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, Long> {
}
