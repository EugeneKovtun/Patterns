package behavioral.state;

/**
 * Created by eugene on 08.08.17.
 */
public class StateApp {
    public static void main(String[] args) {
//        Radio radio = new Radio();
//        radio.setStation(new RadioRocks());
//        for (int i = 0; i < 10; i++) {
//            radio.nextStation();
//            radio.play();
//        }
        Human human = new Human();
        human.setState(new  Work());
        for (int i = 0; i <10 ; i++) {
            human.doSomething();
        }
    }
}

interface Station {
    void play();
}

class RadioRocks implements Station {
    @Override
    public void play() {
        System.out.println("eeeeeeeee rock");
    }
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("radio7");
    }
}

class DJFM implements Station {
    @Override
    public void play() {
        System.out.println("DJFM.play");
    }
}

class Radio {
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    public void nextStation() {
        if (station instanceof RadioRocks) {
            setStation(new Radio7());
        } else if (station instanceof Radio7) {
            setStation(new DJFM());
        } else {
            setStation(new RadioRocks());
        }
    }

    public void play() {
        station.play();
    }
}

class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    @Override
    public void doSomething(Human context) {
        System.out.println("Work.doSomething");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity {
    private int counter = 0;

    @Override
    public void doSomething(Human context) {
        if (counter < 3) {
            System.out.println("WeekEnd.doSomething");
            counter++;
        } else {
            context.setState(new Work());
        }
    }
}