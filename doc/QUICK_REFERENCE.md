# Quick Reference Guide

## Design Patterns Overview

### 1. Singleton Pattern - Patient Database
**Class:** `PatientDatabaseManager`

**What it does:** Ensures only one patient database exists.

**How to use:**
```java
PatientDatabaseManager db = PatientDatabaseManager.getInstance();
db.addPatient(new Patient("001", "John", 30));
```

---

### 2. Factory Pattern - Object Creation
**Classes:** `MedicalRecordFactory`, `DoctorFactory`

**What it does:** Creates objects without specifying exact class.

**How to use:**
```java
// Create medical record
MedicalRecord record = MedicalRecordFactory.createRecord("Prescription");

// Create doctor
Doctor doctor = DoctorFactory.createDoctor("Cardiologist");
```

---

### 3. Decorator Pattern - Add Services
**Classes:** `BasicAppointment`, `LabTestDecorator`, `XRayDecorator`, `MRIScanDecorator`

**What it does:** Adds services to appointments dynamically.

**How to use:**
```java
Appointment appt = new BasicAppointment();           // $100
appt = new LabTestDecorator(appt);                   // +$50
appt = new XRayDecorator(appt);                      // +$150
System.out.println(appt.getCost());                  // $300
```

---

### 4. Observer Pattern - Notifications
**Classes:** `AppointmentSubject`, `PatientObserver`, `DoctorObserver`, `ReceptionistObserver`

**What it does:** Notifies multiple parties about appointments.

**How to use:**
```java
AppointmentSubject subject = new AppointmentSubject();
subject.attach(new PatientObserver());
subject.attach(new DoctorObserver());
subject.notifyObservers("New appointment booked");
```

---

### 5. Adapter Pattern - Legacy Integration
**Classes:** `InsuranceAdapter`, `LegacyInsuranceSystem`

**What it does:** Converts old insurance format to new format.

**How to use:**
```java
InsuranceService service = new InsuranceAdapter();
InsuranceCoverage coverage = service.getCoverage("P001");
System.out.println(coverage.getCoveragePercentage());
```

---

### 6. Proxy Pattern - Access Control
**Classes:** `MedicalRecordProxy`, `RealMedicalRecordAccess`

**What it does:** Logs all access to medical records.

**How to use:**
```java
MedicalRecordAccess proxy = new MedicalRecordProxy("Dr. Smith");
String record = proxy.viewRecord("REC001");
String log = proxy.getAccessLog();  // See who accessed what
```

---

## Class Diagram Summary

```
Models
├── Patient

Singleton
├── PatientDatabaseManager

Factory
├── MedicalRecordFactory
│   ├── Prescription
│   ├── LabResult
│   └── PatientHistory
└── DoctorFactory
    ├── Cardiologist
    ├── Neurologist
    └── GeneralPractitioner

Decorator
├── Appointment (interface)
├── BasicAppointment
└── AppointmentDecorator (abstract)
    ├── LabTestDecorator
    ├── XRayDecorator
    └── MRIScanDecorator

Observer
├── Observer (interface)
├── AppointmentSubject
├── PatientObserver
├── DoctorObserver
└── ReceptionistObserver

Adapter
├── InsuranceService (interface)
├── InsuranceAdapter
├── LegacyInsuranceSystem
└── InsuranceCoverage

Proxy
├── MedicalRecordAccess (interface)
├── MedicalRecordProxy
└── RealMedicalRecordAccess
```

---

## Pattern Selection Guide

| Need to... | Use Pattern | Example Class |
|------------|-------------|---------------|
| Ensure single instance | Singleton | PatientDatabaseManager |
| Create different types | Factory | MedicalRecordFactory |
| Add optional features | Decorator | LabTestDecorator |
| Notify multiple parties | Observer | AppointmentSubject |
| Integrate legacy system | Adapter | InsuranceAdapter |
| Control/log access | Proxy | MedicalRecordProxy |

---

## Key Benefits

✅ **Maintainable** - Easy to understand and modify
✅ **Extensible** - Add new features without breaking existing code
✅ **Reusable** - Patterns can be applied to other projects
✅ **Professional** - Follows industry best practices
✅ **Testable** - Patterns promote loose coupling
