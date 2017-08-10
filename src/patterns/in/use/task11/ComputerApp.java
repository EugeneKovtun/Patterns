package patterns.in.use.task11;

/**
 * Created by eugene on 10.08.17.
 */
public class ComputerApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRom.loadData();
        hdd.copyFromDVD(dvdRom);
        power.off();
    }
}

class Power {
    public void on() {
        System.out.println("Power.on");
    }

    public void off() {
        System.out.println("Power.off");
    }
}

class DVDRom {
    boolean data = false;

    public boolean isData() {
        return data;
    }

    public void loadData() {
        data = true;
    }

    public void unloadData() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.isData()) {
            System.out.println("Loading data");
        } else {
            System.out.println("Input disk");
        }
    }
}