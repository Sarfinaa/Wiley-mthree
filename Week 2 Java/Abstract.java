abstract class Vehicle {
    abstract void drive();

    abstract void steeringMechanisms();

    void start() {
        System.out.println("Vehicle Started");
    }

    void stop() {
        System.out.println("Vehicle Stopped");
    }
}

class Bike extends Vehicle {
    @Override
    void drive() {
        System.out.println("Drive Bike");
    }

    @Override
    void steeringMechanisms() {
        System.out.println("Bike steering Mechanisms");
    }
}

class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive Car");
    }

    @Override
    public void steeringMechanisms() {
        System.out.println("Car steering Mechanisms");
    }
}

public class Abstract {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();
        bike.drive();
        car.drive();
    }
}
