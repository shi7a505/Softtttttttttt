package adapter;

public class LegacyInsuranceSystem {
    public String checkPatientInsurance(String patientId) {
        
        if (patientId != null && !patientId.isEmpty()) {
            int idHash = patientId.hashCode() % 100;
            double coverage = 70 + (idHash % 30);
            double limit = 5000 + (idHash % 20) * 1000;
            return patientId + "|" + coverage + "|" + limit;
        }
        
        return "UNKNOWN|0|0";
    }
}
