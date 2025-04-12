package com.example.esercizio_piattaforma_cars.controller;

import com.example.esercizio_piattaforma_cars.entity.Car;
import com.example.esercizio_piattaforma_cars.entity.CarType;
import com.example.esercizio_piattaforma_cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
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
}
