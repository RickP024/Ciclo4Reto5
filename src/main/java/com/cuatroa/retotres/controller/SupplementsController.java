package com.cuatroa.retotres.controller;

import com.cuatroa.retotres.model.Supplements;
import com.cuatroa.retotres.service.SupplementsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplements")
@CrossOrigin("*")
public class SupplementsController {
    @Autowired
    private SupplementsService supplementsService;
    @GetMapping("/all")
    public List<Supplements> getAll() {
        return supplementsService.getAll();
    }
    @GetMapping("/{reference}")
    public Optional<Supplements> getSupplement(@PathVariable("reference") String reference) {
        return supplementsService.getSupplement(reference);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplements create(@RequestBody Supplements gadget) {
        return supplementsService.create(gadget);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplements update(@RequestBody Supplements gadget) {
        return supplementsService.update(gadget);
    }
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return supplementsService.delete(reference);
    }
    @GetMapping("/price/{price}")
    public List<Supplements> getByPrice(@PathVariable("price") double price) {
        return supplementsService.getByPrice(price);
    }
    @GetMapping("/description/{description}")
    public List<Supplements> getByDescriptionContains(@PathVariable("description") String description) {
        return supplementsService.getByDescriptionContains(description);
    }
    
}
