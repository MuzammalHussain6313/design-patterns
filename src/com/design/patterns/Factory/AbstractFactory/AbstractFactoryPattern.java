package com.design.patterns.Factory.AbstractFactory;

// 1. Product interfaces
abstract class Vehicle {
    public abstract void printVehicle();
}

abstract class Engine {
    public abstract void printEngine();
}

// 2. Concrete vehicle products
class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am a two wheeler");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am a four wheeler");
    }
}

// 3. Concrete engine products
class TwoWheelerEngine extends Engine {
    public void printEngine() {
        System.out.println("I have a small engine for two wheeler");
    }
}

class FourWheelerEngine extends Engine {
    public void printEngine() {
        System.out.println("I have a powerful engine for four wheeler");
    }
}

// 4. Abstract Factory Interface
interface AbstractVehicleFactory {
    Vehicle createVehicle();
    Engine createEngine();
}

// 5. Concrete Factories
class TwoWheelerFactory implements AbstractVehicleFactory {
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }

    public Engine createEngine() {
        return new TwoWheelerEngine();
    }
}

class FourWheelerFactory implements AbstractVehicleFactory {
    public Vehicle createVehicle() {
        return new FourWheeler();
    }

    public Engine createEngine() {
        return new FourWheelerEngine();
    }
}

// 6. Client
class AbstractFactoryClient {
    private Vehicle vehicle;
    private Engine engine;

    public AbstractFactoryClient(AbstractVehicleFactory factory) {
        vehicle = factory.createVehicle();
        engine = factory.createEngine();
    }

    public void showDetails() {
        vehicle.printVehicle();
        engine.printEngine();
    }
}

// 7. Main class to test the Abstract Factory Pattern
public class AbstractFactoryPattern {
    public static void main(String[] args) {

        AbstractVehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        AbstractFactoryClient twoWheelerClient = new AbstractFactoryClient(twoWheelerFactory);
        System.out.println("Two Wheeler Setup:");
        twoWheelerClient.showDetails();

        System.out.println();

        AbstractVehicleFactory fourWheelerFactory = new FourWheelerFactory();
        AbstractFactoryClient fourWheelerClient = new AbstractFactoryClient(fourWheelerFactory);
        System.out.println("Four Wheeler Setup:");
        fourWheelerClient.showDetails();
    }
}

