package proxy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordProxy implements MedicalRecordAccess {
    private RealMedicalRecordAccess realAccess;
    private List<String> accessLog;
    private String userName;
    
    public MedicalRecordProxy(String userName) {
        this.userName = userName;
        this.accessLog = new ArrayList<>();
    }
    
    private void logAccess(String operation, String recordId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = String.format("[%s] User: %s | Operation: %s | Record: %s", 
                                       timestamp, userName, operation, recordId);
        accessLog.add(logEntry);
    }
    
    @Override
    public String viewRecord(String recordId) {
        
        if (realAccess == null) {
            realAccess = new RealMedicalRecordAccess();
        }
        
        logAccess("VIEW", recordId);
        
        return realAccess.viewRecord(recordId);
    }
    
    @Override
    public String getAccessLog() {
        StringBuilder log = new StringBuilder("=== Access Log ===\n\n");
        for (String entry : accessLog) {
            log.append(entry).append("\n");
        }
        return log.toString();
    }
}
