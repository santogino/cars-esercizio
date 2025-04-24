package com.example.esercizio_piattaforma_cars.controller;

import com.example.esercizio_piattaforma_cars.component.CarTestPopulator;
import com.example.esercizio_piattaforma_cars.entity.Car;
import com.example.esercizio_piattaforma_cars.entity.CarColor;
import com.example.esercizio_piattaforma_cars.entity.CarType;
import com.example.esercizio_piattaforma_cars.service.CarService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    CarTestPopulator carTestPopulator;

    @PostMapping("/sample")
    @ResponseStatus(HttpStatus.OK)
    public void addSampleCars() {
        carTestPopulator.addSampleCars();
    }

    @GetMapping("/name-paged")
    public Page<Car> getCarsByNamePageable(
            @Nullable @RequestParam String modelName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        if (modelName != null && !modelName.isBlank()){
            return carService.getCarsByModelName(modelName, pageable);
        } else {
            return carService.findAll(pageable);
        }
    }

    @GetMapping("/all")
    public List<Car> findAll() {
        return carService.findAll();
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {

        return carService.addCar(car)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Car> deleteCars() {
        carService.deleteCars();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Car> deleteById(@PathVariable Long id) {
        if (id < 0) {
            ResponseEntity.badRequest().build();
        }
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {

        return carService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> updateTypeById(@PathVariable Long id, @RequestParam CarType type) {
        if (id < 0) {
            return ResponseEntity.badRequest().build();
        }

        return carService.updateTypeById(id, type)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/type-color")
    public List<Car> getCarsByTypeAndColor (@RequestParam CarType type, @RequestParam CarColor color) {
        return carService.getCarsForTypeAndColor(type, color);
    }
}
