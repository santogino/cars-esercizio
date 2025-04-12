package com.example.esercizio_piattaforma_cars.repository;

import com.example.esercizio_piattaforma_cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
