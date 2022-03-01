package week_4.reflect;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Class;
import java.lang.reflect.*;

class Vehicle {
    public String brand;
    public int noOfWheels;
    public boolean isRegistered;

    Vehicle() {
        isRegistered = false;
    }

    Vehicle(String brand, int noOfWheels) {
        this();
        this.brand = brand;
        this.noOfWheels = noOfWheels;
    }

    private void displayDrivingOrientation() {
        System.out.println("Driving Orientation: Left");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public void register(String brand, int noOfWheels) {
        setBrand(brand);
        setNoOfWheels(noOfWheels);
        System.out.println("Brand : " + getBrand());
        System.out.println("No of Wheels:" + getNoOfWheels());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Registration Date: " + formatter.format(calendar.getTime()));
        displayDrivingOrientation();
        isRegistered = true;
    }

}

class Car extends Vehicle {
    public String carName;
    public int yearOfManufacturing;

    Car(String brand, int noOfWheels, String carName) {
        super(brand, noOfWheels);
        this.carName = carName;
        yearOfManufacturing = 2021;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public void setYearOfManufacturing(int yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
    }

    @Override
    public String toString() {
        return "Car [carName=" + carName + ", yearOfManufacturing=" + yearOfManufacturing + ", brandNamme=" + getBrand()
                + ", noOfWheels=" + getNoOfWheels() + ", isRegistered=" + isRegistered + "]";
    }

    public void registerCar(String brand, int noOfWheels) {
        register(brand, noOfWheels);
    }
}

public class Driver {
    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Car audi = new Car("Audi", 4, "Audi R8");
        audi.registerCar(audi.getBrand(), audi.getNoOfWheels());
        Class audicls = audi.getClass();
        System.out.println("Car object class name: " + audicls.getSimpleName());
        System.out.println("Car object parent class name: " + audicls.getSuperclass().getSimpleName());
        Constructor[] constructors = audicls.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("Constructor Name: " + c.getName());
        }
        Method[] methods = audicls.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method Name: " + m.getName());

        }
        Field field1 = audicls.getDeclaredField("carName");
        Field field2 = audicls.getField("isRegistered");
        System.out.println(field1.get(audi));
        System.out.println(field2.get(audi));
        field1.set(audi, "Audi R7");
        field2.set(audi, false);
        System.out.println("Modified Car Name: " + field1.get(audi));
        System.out.println("Modified isRegistered: " + field2.get(audi));
        System.out.println(audi);
    }
}