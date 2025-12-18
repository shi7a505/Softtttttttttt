package observer;

import java.util.ArrayList;
import java.util.List;

public class AppointmentSubject {
    private List<Observer> observers = new ArrayList<>();
    
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    
    public List<Observer> getObservers() {
        return new ArrayList<>(observers);
    }
}
