package com.example.esercizio_piattaforma_cars;

import com.example.esercizio_piattaforma_cars.entity.Car;
import com.example.esercizio_piattaforma_cars.entity.CarColor;
import com.example.esercizio_piattaforma_cars.entity.CarType;
import com.example.esercizio_piattaforma_cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsercizioPiattaformaCarsApplication{
    public static void main(String[] args) {
        SpringApplication.run(EsercizioPiattaformaCarsApplication.class, args);
    }
}

