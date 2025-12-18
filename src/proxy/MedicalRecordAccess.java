package proxy;

public interface MedicalRecordAccess {
    String viewRecord(String recordId);
    String getAccessLog();
}
