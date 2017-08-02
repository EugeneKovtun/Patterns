/**
 * Created by eugene on 03.08.17.
 */
public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildName("Best")
                .buildSpeed(123)
                .buildTransmission(Transmission.MANUAL)
                .build();
        System.out.println(car);
    }
}
enum Transmission{
    AUTO,MANUAL
}
class Car{
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
class CarBuilder{
    String name;
    Transmission transmission;
    int speed;

    CarBuilder buildName(String name){
     this.name = name;
     return this;
    }
    CarBuilder buildTransmission(Transmission transmission){
        this.transmission = transmission;
        return this;
    }
    CarBuilder buildSpeed(int speed){
        this.speed = speed;
        return this;
    }
    Car build(){
        Car car =new Car();
        car.setName(name);
        car.setTransmission(transmission);
        car.setSpeed(speed);
        return car;
    }
}