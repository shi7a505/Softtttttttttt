package decorator;

public class BasicAppointment implements Appointment {
    @Override
    public double getCost() {
        return 100.0;
    }
    
    @Override
    public String getDescription() {
        return "Basic Consultation";
    }
}
