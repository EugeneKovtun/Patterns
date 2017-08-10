package patterns.in.use.task4;

/**
 * Created by eugene on 10.08.17.
 */
public class PlaneApp {
    public static void main(String[] args) {
        Plane plane = new Plane(new MachineGun());
        plane.execute();
    }
}
class Plane{
    PlaneState planeState;

    public Plane(PlaneState planeState) {
        this.planeState = planeState;
    }
    public void execute(){
        planeState.doAction();
    }
}

interface PlaneState {
    void doAction();
}

class PlaneStay implements PlaneState {
    @Override
    public void doAction() {
        System.out.println("plane is staying");
    }
}

class UnableToShoot implements PlaneState {
    @Override
    public void doAction() {
        System.out.println("No ammo/no gun");
    }
}

abstract class Shoot implements PlaneState {
    @Override
    public void doAction() {
        shoot();
    }

    abstract void shoot();
}

class MachineGun extends Shoot {
    @Override
    void shoot() {
        System.out.println("MachineGun.shoot");
    }
}

class Gun extends Shoot {
    @Override
    void shoot() {
        System.out.println("Gun.shoot");
    }
}

class Rocket extends Shoot {
    @Override
    void shoot() {
        System.out.println("Rocket.shoot");
    }
}