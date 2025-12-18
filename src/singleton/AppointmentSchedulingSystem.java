package singleton;

import models.Appointment;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class AppointmentSchedulingSystem {
    private static AppointmentSchedulingSystem instance;
    private List<Appointment> appointments;
    private Map<String, Boolean> timeSlotAvailability;
    
    private AppointmentSchedulingSystem() {
        appointments = new ArrayList<>();
        timeSlotAvailability = new HashMap<>();
        initializeTimeSlots();
    }
    
    public static synchronized AppointmentSchedulingSystem getInstance() {
        if (instance == null) {
            instance = new AppointmentSchedulingSystem();
        }
        return instance;
    }
    
    private void initializeTimeSlots() {
        
        String[] times = {"09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00"};
        for (String time : times) {
            timeSlotAvailability.put(time, true);
        }
    }
    
    public synchronized boolean bookAppointment(Appointment appointment) {
        String slot = appointment.getTimeSlot();
        
        if (Boolean.TRUE.equals(timeSlotAvailability.get(slot))) {
            appointments.add(appointment);
            timeSlotAvailability.put(slot, false);
            return true;
        }
        return false;
    }
    
    public synchronized boolean cancelAppointment(String appointmentId) {
        if (appointmentId == null) {
            return false;
        }
        
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointmentId.equals(appointment.getAppointmentId())) {
                iterator.remove();
                timeSlotAvailability.put(appointment.getTimeSlot(), true);
                return true;
            }
        }
        return false;
    }
    
    public synchronized boolean checkAvailability(String timeSlot) {
        return Boolean.TRUE.equals(timeSlotAvailability.get(timeSlot));
    }
    
    public synchronized List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }
    
    public synchronized int getAppointmentCount() {
        return appointments.size();
    }
    
    public synchronized List<String> getAvailableSlots() {
        List<String> availableSlots = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : timeSlotAvailability.entrySet()) {
            if (entry.getValue()) {
                availableSlots.add(entry.getKey());
            }
        }
        return availableSlots;
    }
}
