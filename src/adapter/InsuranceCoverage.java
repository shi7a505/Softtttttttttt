package adapter;

public class InsuranceCoverage {
    private String patientId;
    private double coveragePercentage;
    private double coverageLimit;
    
    public InsuranceCoverage(String patientId, double coveragePercentage, double coverageLimit) {
        this.patientId = patientId;
        this.coveragePercentage = coveragePercentage;
        this.coverageLimit = coverageLimit;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public double getCoveragePercentage() {
        return coveragePercentage;
    }
    
    public double getCoverageLimit() {
        return coverageLimit;
    }
    
    @Override
    public String toString() {
        return "Insurance Coverage for Patient ID: " + patientId + "\n" +
               "Coverage Percentage: " + coveragePercentage + "%\n" +
               "Coverage Limit: $" + coverageLimit;
    }
}
