package observer;

public class ReceptionistObserver implements Observer {
    @Override
    public void update(String message) {
        
    }
    
    public String getNotification(String message) {
        return "Receptionist Notification: " + message;
    }
}
