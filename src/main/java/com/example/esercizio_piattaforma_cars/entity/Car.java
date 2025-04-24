package com.example.esercizio_piattaforma_cars.entity;

import jakarta.persistence.*;

//id
//modelName - obbligatorio
//type - Enum - obbligatorio
//color - Enum - obbligatorio
//description - String- non obbligatorio
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelName;

    @Enumerated(EnumType.STRING)
    private CarType type;

    @Enumerated(EnumType.STRING)
    private CarColor color;

    private String description;

    private Car() {}

    public Car(String modelName, CarType type, CarColor color, String description) {
        this.modelName = modelName;
        this.type = type;
        this.color = color;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
