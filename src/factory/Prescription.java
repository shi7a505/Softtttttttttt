package factory;

public class Prescription implements MedicalRecord {
    @Override
    public String getRecordType() {
        return "Prescription";
    }
    
    @Override
    public String getDetails() {
        return "Record Type: Prescription\n" +
               "Description: Medical prescription for patient treatment\n" +
               "Contains: Medication names, dosages, and instructions\n" +
               "Status: Ready for pharmacy";
    }
}
