# Medical Clinic Management System - نظام إدارة العيادة الطبية

A simple Java desktop application demonstrating 5 design patterns for a medical clinic management system.

This is a university coursework project showcasing design pattern implementation.

---

## 🎯 Design Patterns Implemented

### 1. **Singleton Pattern** - Patient Database Manager
- Ensures only one instance of the patient database exists
- Manages all patient records centrally

### 2. **Factory Pattern** - Medical Records
- Creates different types of medical records (Prescription, Lab Result, Patient History)
- Centralizes object creation logic

### 3. **Decorator Pattern** - Appointment Services
- Dynamically adds services to appointments
- Calculates total cost with optional services (Lab Test, X-Ray, MRI)

### 4. **Observer Pattern** - Notification System
- Notifies multiple observers (Patient, Doctor, Receptionist) about appointments
- Demonstrates event-driven communication

### 5. **Adapter Pattern** - Insurance Check
- Adapts legacy insurance system to modern interface
- Converts old data format to new format seamlessly

---

## 📂 Project Structure

```
Software-Proj/
├── src/
│   ├── MedicalClinicGUI.java          ← Main GUI with 5 tabs
│   │
│   ├── models/
│   │   └── Patient.java               ← Patient data model
│   │
│   ├── singleton/
│   │   └── PatientDatabaseManager.java
│   │
│   ├── factory/
│   │   ├── MedicalRecord.java
│   │   ├── Prescription.java
│   │   ├── LabResult.java
│   │   ├── PatientHistory.java
│   │   └── MedicalRecordFactory.java
│   │
│   ├── decorator/
│   │   ├── Appointment.java
│   │   ├── BasicAppointment.java
│   │   ├── AppointmentDecorator.java
│   │   ├── LabTestDecorator.java
│   │   ├── XRayDecorator.java
│   │   └── MRIScanDecorator.java
│   │
│   ├── observer/
│   │   ├── Observer.java
│   │   ├── PatientObserver.java
│   │   ├── DoctorObserver.java
│   │   ├── ReceptionistObserver.java
│   │   └── AppointmentSubject.java
│   │
│   └── adapter/
│       ├── InsuranceService.java
│       ├── InsuranceCoverage.java
│       ├── LegacyInsuranceSystem.java
│       └── InsuranceAdapter.java
│
└── README.md
```

---

## 🚀 How to Build and Run

### Prerequisites
- Java JDK 8 or higher
- Terminal/Command Prompt

### Compile the Project

```bash
cd src
javac MedicalClinicGUI.java
```

### Run the Application

```bash
java MedicalClinicGUI
```

---

## 💻 GUI Features

The application has **ONE main window** with **5 tabs**:

### **Tab 1: Singleton Pattern**
- Add patient name and age
- View all patients in the database
- Demonstrates single instance of PatientDatabaseManager

### **Tab 2: Factory Pattern**
- Select record type from dropdown (Prescription, Lab Result, Patient History)
- Create medical records using factory
- View record details

### **Tab 3: Decorator Pattern**
- Start with Basic Consultation ($100)
- Add optional services:
  - Lab Test (+$50)
  - X-Ray (+$150)
  - MRI Scan (+$500)
- Calculate total cost dynamically

### **Tab 4: Observer Pattern**
- Enter patient name, doctor name, and date
- Book appointment
- See notifications sent to Patient, Doctor, and Receptionist

### **Tab 5: Adapter Pattern**
- Enter patient ID
- Check insurance coverage
- View coverage percentage and limit (adapted from legacy system)

---

## 🎓 Educational Purpose

This project demonstrates:
- Clean code organization
- Proper use of design patterns
- Java Swing GUI development
- Object-oriented programming principles

---

## 📝 Notes

- This is a simple university project for demonstration purposes
- The application uses in-memory storage (data is not persisted)
- Sample data is generated for insurance coverage based on patient ID

---
