package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.Supplements;
import com.cuatroa.retotres.repository.SupplementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

@Service
public class SupplementsService {
    @Autowired
    private SupplementsRepository supplementRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Supplements> getAll() {
        return supplementRepository.getAll();
    }
    public Optional<Supplements> getSupplement(String reference) {
        return supplementRepository.getSupplement(reference);
    }
    public Supplements create(Supplements supplement) {
        if (supplement.getReference() == null) {
            return supplement;
        } else {
            return supplementRepository.create(supplement);
        }
    }
    public Supplements update(Supplements supplement) {
        if (supplement.getReference() != null) {
            Optional<Supplements> supplementDb = supplementRepository.getSupplement(supplement.getReference());
            if (!supplementDb.isEmpty()) {
                if (supplement.getBrand() != null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }
                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getObjetivo() != null) {
                    supplementDb.get().setObjetivo(supplement.getObjetivo());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());
                supplementRepository.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }
    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(supplement -> {
            supplementRepository.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public List<Supplements> getByPrice(double price) {
        return supplementRepository.getByPrice(price);
    }
    public List<Supplements> getByDescriptionContains(String description) {
        return supplementRepository.getByDescriptionContains(description);
    }
}
