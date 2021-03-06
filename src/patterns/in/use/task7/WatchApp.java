package patterns.in.use.task7;

import java.util.Date;

/**
 * Created by eugene on 10.08.17.
 */
public class WatchApp {
    public static void main(String[] args) {
        Watch watch = createWatchMakerByName("digital").createWatch();
        watch.showTime();
    }
    public static WatchMaker createWatchMakerByName(String name) {
        if (name.equalsIgnoreCase("digital")) {
            return new DigitalWatchMaker();
        } else if (name.equalsIgnoreCase("rome")) {
            return new RomeWatchMaker();
        }
        throw new IllegalArgumentException("Watch line" + name + "not found");
    }
}
interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("XX-XVI");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}