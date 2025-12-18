package observer;

public class PatientObserver implements Observer {
    @Override
    public void update(String message) {
        
    }
    
    public String getNotification(String message) {
        return "Patient Notification: " + message;
    }
}
