package models;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private String timeSlot;
    
    public Appointment(String appointmentId, String patientName, String doctorName, String date, String timeSlot) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.timeSlot = timeSlot;
    }
    
    public String getAppointmentId() {
        return appointmentId;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public String getDoctorName() {
        return doctorName;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTimeSlot() {
        return timeSlot;
    }
    
    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + 
               " | Patient: " + patientName + 
               " | Doctor: " + doctorName + 
               " | Date: " + date + 
               " | Time: " + timeSlot;
    }
}
