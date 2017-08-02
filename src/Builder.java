/**
 * Created by eugene on 03.08.17.
 */
public class Builder {
    public static void main(String[] args) {
        Director director = new Director();
        director.setCarBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}

enum Transmission {
    AUTO, MANUAL
}

class Car {
    String name = "Default";
    Transmission transmission = Transmission.AUTO;
    int speed = 120;

    public void setName(String name) {
        this.name = name;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", transmission=" + transmission +
                ", speed=" + speed +
                '}';
    }
}

abstract class CarBuilder {
    Car car;
    void createCar(){car = new Car();}

    abstract void buildName();

    abstract void buildTransmission();

    abstract void buildSpeed();

    public Car getCar() {
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder {
    @Override
    void buildName() {
        car.setName("Ford Mondeo");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(300);
    }
}

class NisanBuilder extends CarBuilder {
    @Override
    void buildName() {
        car.setName("Nisan");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(250);
    }
}

class Director{
    CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    Car buildCar(){
        carBuilder.createCar();
        carBuilder.buildName();
        carBuilder.buildSpeed();
        carBuilder.buildTransmission();
        Car car = carBuilder.getCar();
        return car;
    }
}
//class CarBuilder{
//    String name;
//    Transmission transmission;
//    int speed;
//
//    CarBuilder buildName(String name){
//     this.name = name;
//     return this;
//    }
//    CarBuilder buildTransmission(Transmission transmission){
//        this.transmission = transmission;
//        return this;
//    }
//    CarBuilder buildSpeed(int speed){
//        this.speed = speed;
//        return this;
//    }
//    Car build(){
//        Car car =new Car();
//        car.setName(name);
//        car.setTransmission(transmission);
//        car.setSpeed(speed);
//        return car;
//    }
//}
