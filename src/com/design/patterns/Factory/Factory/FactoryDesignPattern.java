package com.design.patterns.Factory.Factory;

// 1. Product interface representing a vehicle
abstract class Vehicle {
    public abstract void printVehicle();
}

// 2. Concrete product classes representing different types of vehicles
class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am four wheeler");
    }
}

class EightWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am eight wheeler");
    }
}

// 3. Factory is responsible to make the object of vehicle based on type
class VehicleFactory {
    public Vehicle getInstance(String type) {
        switch (type) {
            case "two": return new TwoWheeler();
            case "four": return new FourWheeler();
            case "eight": return new EightWheeler();
            default: return null;
        }
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle twoWheeler = vehicleFactory.getInstance("two");
        twoWheeler.printVehicle(); // use vehicle object

        Vehicle fourWheeler = vehicleFactory.getInstance("four");
        fourWheeler.printVehicle(); // use vehicle object

        Vehicle eightWheeler = vehicleFactory.getInstance("eight");
        eightWheeler.printVehicle(); // use vehicle object
    }
}



