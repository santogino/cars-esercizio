package com.example.esercizio_piattaforma_cars.component;

import com.example.esercizio_piattaforma_cars.entity.Car;
import com.example.esercizio_piattaforma_cars.entity.CarColor;
import com.example.esercizio_piattaforma_cars.entity.CarType;
import com.example.esercizio_piattaforma_cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CarTestPopulator {

    @Autowired
    CarService carService;

    public void addSampleCars() {
        List<Car> cars = new ArrayList<>();

        // Dati di esempio
        String[] modelNames = {"Fiat 500", "Tesla Model S", "BMW X5", "Audi A3", "Ford Focus",
                "Toyota Corolla", "Nissan Qashqai", "Honda Civic", "Jeep Wrangler", "Volkswagen Golf"};
        CarType[] types = CarType.values();
        CarColor[] colors = CarColor.values();

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            String modelName = modelNames[random.nextInt(modelNames.length)];
            CarType type = types[random.nextInt(types.length)];
            CarColor color = colors[random.nextInt(colors.length)];

            // Creazione opzionale di una descrizione
            String description = random.nextBoolean() ? "Descrizione per " + modelName : null;

            // Creazione dell'oggetto Car
            Car car = new Car(modelName, type, color, description);

            // Aggiunta alla lista
            cars.add(car);
        }

        // Salvataggio delle auto nel database tramite il servizio
        cars.forEach(carService::addCar);
    }
}

