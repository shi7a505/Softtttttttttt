package factory;

public class PatientHistory implements MedicalRecord {
    @Override
    public String getRecordType() {
        return "Patient History";
    }
    
    @Override
    public String getDetails() {
        return "Record Type: Patient History\n" +
               "Description: Complete medical history of patient\n" +
               "Contains: Past illnesses, surgeries, allergies, and family history\n" +
               "Status: Archived";
    }
}
