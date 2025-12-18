package proxy;

import java.util.HashMap;
import java.util.Map;

public class RealMedicalRecordAccess implements MedicalRecordAccess {
    private Map<String, String> medicalRecords;
    
    public RealMedicalRecordAccess() {
        medicalRecords = new HashMap<>();
        loadRecords();
    }
    
    private void loadRecords() {
        
        medicalRecords.put("REC001", "Patient: Ahmed Ali\nDiagnosis: Hypertension\nMedication: Amlodipine 5mg");
        medicalRecords.put("REC002", "Patient: Sara Mohamed\nDiagnosis: Diabetes Type 2\nMedication: Metformin 500mg");
        medicalRecords.put("REC003", "Patient: Omar Hassan\nDiagnosis: Asthma\nMedication: Ventolin Inhaler");
    }
    
    @Override
    public String viewRecord(String recordId) {
        if (medicalRecords.containsKey(recordId)) {
            return medicalRecords.get(recordId);
        }
        return "Record not found: " + recordId;
    }
    
    @Override
    public String getAccessLog() {
        return "Real system - no logging";
    }
}
