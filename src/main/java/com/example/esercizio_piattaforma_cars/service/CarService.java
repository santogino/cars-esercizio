package com.example.esercizio_piattaforma_cars.service;

import com.example.esercizio_piattaforma_cars.entity.Car;
import com.example.esercizio_piattaforma_cars.entity.CarType;
import com.example.esercizio_piattaforma_cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//crea nuova Car
//restituisce la lista di tutte le Car
//restituisce una singola Car - se id non è presente in db (usa existsById()), restituisce 404
//aggiorna type della Car specifica, identificata da id e passando query param - se id non è presente in db (usa existsById()), restituisce 404
//cancella la Car specifica - se non presente, 404
//cancella tutte le Cars in db
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private List<Car> cars = new ArrayList<>();

    //find All - trova tutte le cars
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    // aggiungi una car - non necessario inserire la description
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
    public Optional<Car> updateTypeById(Long id, Car car, CarType type) {
        if (!carRepository.existsById(id)) {
            return Optional.empty();
        }

        car.setType(type);
        return Optional.of(carRepository.save(car));
    }
}
