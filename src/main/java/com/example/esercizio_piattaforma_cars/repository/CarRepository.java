package com.example.esercizio_piattaforma_cars.repository;

import com.example.esercizio_piattaforma_cars.entity.Car;
import com.example.esercizio_piattaforma_cars.entity.CarColor;
import com.example.esercizio_piattaforma_cars.entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByModelName(String modelName);

    @Query("SELECT c FROM Car c WHERE c.type = :type AND c.color = :color")
    List<Car> findForTypeAndColor(CarType type, CarColor color);
}
