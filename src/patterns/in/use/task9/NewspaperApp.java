package patterns.in.use.task9;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 10.08.17.
 */
public class NewspaperApp {
    public static void main(String[] args) {
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.addObserver(new Observer());
        publishingHouse.addObserver(new Observer());
        publishingHouse.printNewspaper();
    }
}

class Observer {
    void handleEvent() {
        System.out.println("New newspapers");

    }
}

interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class PublishingHouse implements Observed {
    List<Observer> observers = new ArrayList<>();
    public void printNewspaper(){
        System.out.println("Newspapers have been printed");
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
            observer.handleEvent();
        }
    }
}