package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EtiquetteRepository extends MongoRepository<Etiquette,Long> {


}
