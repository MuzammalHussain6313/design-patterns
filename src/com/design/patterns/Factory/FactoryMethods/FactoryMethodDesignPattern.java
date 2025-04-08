package com.design.patterns.Factory.FactoryMethods;


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

// To make 'Factory method deign pattern' from above we can make VehicleFactory class into interface
// and give a separate implementation of this interface like below

interface VehicleFactory {
    Vehicle createVehicle();
}

class TwoWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class FourWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

class EightWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new EightWheeler();
    }
}

public class FactoryMethodDesignPattern {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new TwoWheelerFactory();
        Vehicle twoWheeler = vehicleFactory.createVehicle();
        twoWheeler.printVehicle(); // use vehicle object

        vehicleFactory = new FourWheelerFactory();
        Vehicle fourWheeler = vehicleFactory.createVehicle();
        fourWheeler.printVehicle(); // use vehicle object

        vehicleFactory = new EightWheelerFactory();
        Vehicle eightWheeler = vehicleFactory.createVehicle();
        eightWheeler.printVehicle(); // use vehicle object
    }
}


