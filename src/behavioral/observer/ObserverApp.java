package behavioral.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 08.08.17.
 */
public class ObserverApp {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(25,750);
        station.setMeasurements( -9,750);
    }
}

interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class WeatherStation implements Observed {
    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int temperature, int pressure);
}

class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.println("temperature = [" + temperature + "], pressure = [" + pressure + "]");
    }
}
class FileObserver implements Observer{
    @Override
    public void handleEvent(int temperature, int pressure) {
        File file;
        try {
            file = File.createTempFile("Temporary","_txt");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("temperature = [" + temperature + "], pressure = [" + pressure + "]");
            printWriter.close();
        }
        catch (IOException ioe){
        }
    }
}
