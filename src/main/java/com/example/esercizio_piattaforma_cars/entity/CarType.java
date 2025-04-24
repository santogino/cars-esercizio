package com.example.esercizio_piattaforma_cars.entity;

public enum CarType {
    BENZINA, // ("B", "Benzina")
    DIESEL, // ("D", "Diesel")
    ELETTRICO; // ("E", "Elettrico")

//    private final String code;
//    private final String description;
//
//    CarType(String description, String code) {
//        this.description = description;
//        this.code = code;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    //TODO Mike
//    public static CarType convertCodeToEnum(String code){
//        CarType findEnum = null;
//        for (CarType carType : CarType.values()){
//            if (carType.getCode().equals(code)){
//                findEnum = carType;
//            }
//        }
//        if (findEnum == null){
//            throw new EnumConstantNotPresentException(CarType.class, "code");
//        }
//        return findEnum;
//    }
}
