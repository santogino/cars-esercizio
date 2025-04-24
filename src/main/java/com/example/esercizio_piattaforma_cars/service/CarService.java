package com.example.esercizio_piattaforma_cars.service;

import com.example.esercizio_piattaforma_cars.entity.Car;
import com.example.esercizio_piattaforma_cars.entity.CarColor;
import com.example.esercizio_piattaforma_cars.entity.CarType;
import com.example.esercizio_piattaforma_cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Page<Car> getCarsByModelName(String modelName, Pageable pageable) {
        return carRepository.findByModelName(modelName, pageable);
    }

    //find All - trova tutte le cars
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    public Optional<Car> addCar(Car car) {
        if (car.getModelName() == null ||
                car.getColor() == null ||
                car.getType() == null
        ) {
            return Optional.empty();
        }

        return Optional.of(carRepository.save(car));
    }

    // cancella tutte le cars
    public void deleteCars() {
        carRepository.deleteAll();
    }

    //cancella la car per Id
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    //trova una car per Id
    public Optional<Car> findById(Long id) {
        if (id < 0) {
            return Optional.empty();
        }
        return carRepository.findById(id);
    }

    //Aggiorna la Type di una Car cercandola per id
    public Optional<Car> updateTypeById(Long id, CarType type) {
        if (!carRepository.existsById(id)) {
            return Optional.empty();
        }

        return carRepository.findById(id)
                .map(car -> {car.setType(type);
                return carRepository.save(car);
                });
    }

    // trova auto per type and color
    public List<Car> getCarsForTypeAndColor (CarType type, CarColor color) {
        return carRepository.findForTypeAndColor(type, color);
    }
}
