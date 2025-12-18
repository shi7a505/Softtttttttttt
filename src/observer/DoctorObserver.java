package observer;

public class DoctorObserver implements Observer {
    @Override
    public void update(String message) {
        
    }
    
    public String getNotification(String message) {
        return "Doctor Notification: " + message;
    }
}
