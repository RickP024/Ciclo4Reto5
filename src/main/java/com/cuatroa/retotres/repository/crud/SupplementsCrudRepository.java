package com.cuatroa.retotres.repository.crud;

import java.util.List;
import com.cuatroa.retotres.model.Supplements;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplementsCrudRepository extends MongoRepository<Supplements, String> {
    public List<Supplements> findByPrice(double price);
    public List<Supplements> findByDescriptionContainsIgnoreCase(String description);
}