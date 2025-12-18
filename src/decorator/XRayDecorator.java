package decorator;

public class XRayDecorator extends AppointmentDecorator {
    public XRayDecorator(Appointment appointment) {
        super(appointment);
    }
    
    @Override
    public double getCost() {
        return appointment.getCost() + 150.0;
    }
    
    @Override
    public String getDescription() {
        return appointment.getDescription() + " + X-Ray";
    }
}
