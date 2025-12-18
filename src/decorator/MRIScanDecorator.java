package decorator;

public class MRIScanDecorator extends AppointmentDecorator {
    public MRIScanDecorator(Appointment appointment) {
        super(appointment);
    }
    
    @Override
    public double getCost() {
        return appointment.getCost() + 500.0;
    }
    
    @Override
    public String getDescription() {
        return appointment.getDescription() + " + MRI Scan";
    }
}
