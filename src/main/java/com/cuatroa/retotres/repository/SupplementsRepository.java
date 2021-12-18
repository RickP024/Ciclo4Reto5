package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.Supplements;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retotres.repository.crud.SupplementsCrudRepository;

@Repository
public class SupplementsRepository {
    @Autowired
    private SupplementsCrudRepository repository;
    public List<Supplements> getAll() {
        return repository.findAll();
    }
    public Optional<Supplements> getSupplement(String reference) {
        return repository.findById(reference);
    }
    public Supplements create(Supplements supplement) {
        return repository.save(supplement);
    }
    public void update(Supplements supplement) {
        repository.save(supplement);
    }
    public void delete(Supplements supplement) {
        repository.delete(supplement);
    }
    public List<Supplements> getByPrice(double price) {
        return repository.findByPrice(price);
    }
    public List<Supplements> getByDescriptionContains(String description) {
        return repository.findByDescriptionContainsIgnoreCase(description);
    }
}
