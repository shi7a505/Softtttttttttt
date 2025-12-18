# Design Pattern Diagrams

## 1. Singleton Pattern - PatientDatabaseManager

```
┌─────────────────────────────────────┐
│   PatientDatabaseManager            │
├─────────────────────────────────────┤
│ - instance: PatientDatabaseManager  │
│ - patients: List<Patient>           │
├─────────────────────────────────────┤
│ - PatientDatabaseManager()          │  ← Private constructor
│ + getInstance(): PatientDatabaseManager  ← Static method
│ + addPatient(Patient)               │
│ + getAllPatients(): List<Patient>   │
└─────────────────────────────────────┘
```

**Flow:**
```
Client 1 ──→ getInstance() ──→ Creates instance (first time only)
                              ↓
Client 2 ──→ getInstance() ──→ Returns existing instance
                              ↓
Client 3 ──→ getInstance() ──→ Returns existing instance
```

---

## 2. Factory Pattern - Medical Records

```
                    ┌─────────────────────┐
                    │ MedicalRecordFactory│
                    └──────────┬──────────┘
                               │ creates
              ┌────────────────┼────────────────┐
              ↓                ↓                ↓
    ┌─────────────┐  ┌─────────────┐  ┌─────────────┐
    │Prescription │  │  LabResult  │  │PatientHistory│
    └─────────────┘  └─────────────┘  └─────────────┘
           ↑                ↑                 ↑
           └────────────────┴─────────────────┘
                    implements
              ┌─────────────────┐
              │ MedicalRecord   │
              │   (interface)   │
              └─────────────────┘
```

**Usage:**
```
Input: "Prescription"    →  Factory  →  Returns: Prescription object
Input: "Lab Result"      →  Factory  →  Returns: LabResult object
Input: "Patient History" →  Factory  →  Returns: PatientHistory object
```

---

## 3. Decorator Pattern - Appointments

```
            ┌────────────────┐
            │  Appointment   │
            │  (interface)   │
            └────────┬───────┘
                     │ implements
        ┌────────────┼────────────┐
        ↓                         ↓
┌───────────────┐      ┌────────────────────┐
│BasicAppointment│      │AppointmentDecorator│
│   $100         │      │    (abstract)      │
└───────────────┘      └────────┬───────────┘
                                │ extends
                    ┌───────────┼───────────┐
                    ↓           ↓           ↓
            ┌──────────┐ ┌──────────┐ ┌──────────┐
            │ LabTest  │ │  XRay    │ │   MRI    │
            │  +$50    │ │  +$150   │ │  +$500   │
            └──────────┘ └──────────┘ └──────────┘
```

**Wrapping Example:**
```
BasicAppointment ($100)
    ↓ wrapped by
LabTestDecorator ($150 total)
    ↓ wrapped by
XRayDecorator ($300 total)
    ↓ wrapped by
MRIScanDecorator ($800 total)
```

---

## 4. Observer Pattern - Notifications

```
┌──────────────────────┐
│ AppointmentSubject   │
├──────────────────────┤
│ - observers: List    │
├──────────────────────┤
│ + attach(Observer)   │
│ + detach(Observer)   │
│ + notifyObservers()  │
└──────────┬───────────┘
           │ notifies
           │
    ┌──────┴──────┬────────────┐
    ↓             ↓            ↓
┌─────────┐  ┌─────────┐  ┌────────────┐
│ Patient │  │ Doctor  │  │Receptionist│
│Observer │  │Observer │  │  Observer  │
└─────────┘  └─────────┘  └────────────┘
     ↑            ↑              ↑
     └────────────┴──────────────┘
              implements
         ┌─────────────┐
         │  Observer   │
         │(interface)  │
         └─────────────┘
```

**Notification Flow:**
```
Appointment Booked
        ↓
AppointmentSubject.notifyObservers("New appointment")
        ↓
    ┌───┴───┬──────────┐
    ↓       ↓          ↓
Patient  Doctor  Receptionist
updated  updated   updated
```

---

## 5. Adapter Pattern - Insurance System

```
┌──────────────────┐
│ InsuranceService │  ← Modern interface
│   (interface)    │
└────────┬─────────┘
         │ implements
         ↓
┌──────────────────┐      ┌────────────────────┐
│InsuranceAdapter  │ ───→ │LegacyInsuranceSystem│
└──────────────────┘ uses └────────────────────┘
         ↓ returns
┌──────────────────┐
│InsuranceCoverage │  ← Modern data format
└──────────────────┘
```

**Data Conversion:**
```
Legacy Format:
"P001|80|5000"  (PatientID|Percentage|Limit)
        ↓
    Adapter parses and converts
        ↓
Modern Format:
InsuranceCoverage {
  patientId: "P001"
  coveragePercentage: 80
  maxCoverageLimit: 5000
}
```

---

## 6. Proxy Pattern - Medical Records

```
Client
  ↓ requests
┌────────────────────┐
│MedicalRecordProxy  │
├────────────────────┤
│ + viewRecord()     │
│ + getAccessLog()   │
└─────────┬──────────┘
          │ delegates to
          ↓
┌──────────────────────────┐
│RealMedicalRecordAccess   │
├──────────────────────────┤
│ + viewRecord()           │
└──────────────────────────┘
```

**Access Flow:**
```
1. Client → Proxy.viewRecord("REC001")
2. Proxy logs: [timestamp] User: Dr.Smith | Operation: VIEW | Record: REC001
3. Proxy → RealAccess.viewRecord("REC001")
4. RealAccess → Returns record data
5. Proxy → Returns data to client
6. Client can view access log anytime
```

---

## Pattern Relationships in the System

```
┌──────────────────────────────────────────────────────┐
│              Medical Clinic System                    │
├──────────────────────────────────────────────────────┤
│                                                       │
│  ┌─────────────┐     ┌──────────────┐               │
│  │  Singleton  │────→│   Factory    │               │
│  │  Database   │     │   Records    │               │
│  └─────────────┘     └──────────────┘               │
│         ↓                    ↓                       │
│  ┌──────────────────────────────────┐               │
│  │        Main Application           │               │
│  └───────────────┬──────────────────┘               │
│                  │                                   │
│     ┌────────────┼────────────┐                     │
│     ↓            ↓            ↓                     │
│  ┌────────┐  ┌────────┐  ┌────────┐               │
│  │Decorator│  │Observer│  │ Adapter│               │
│  │Appoint. │  │Notify  │  │Insurance│              │
│  └────────┘  └────────┘  └────────┘               │
│                                ↓                     │
│                           ┌────────┐                │
│                           │ Proxy  │                │
│                           │Records │                │
│                           └────────┘                │
└──────────────────────────────────────────────────────┘
```

---

## Benefits Visualization

```
┌─────────────────────────────────────────────────┐
│                Without Patterns                  │
├─────────────────────────────────────────────────┤
│ ❌ Multiple database instances                  │
│ ❌ Complex object creation                      │
│ ❌ Many appointment classes                     │
│ ❌ Tight coupling for notifications             │
│ ❌ Cannot integrate legacy system               │
│ ❌ No access logging                            │
└─────────────────────────────────────────────────┘
                      ↓ Apply Patterns ↓
┌─────────────────────────────────────────────────┐
│                 With Patterns                    │
├─────────────────────────────────────────────────┤
│ ✅ Single database instance (Singleton)         │
│ ✅ Simple object creation (Factory)             │
│ ✅ Flexible appointments (Decorator)            │
│ ✅ Automatic notifications (Observer)           │
│ ✅ Legacy integration (Adapter)                 │
│ ✅ Secure access logging (Proxy)                │
└─────────────────────────────────────────────────┘
```

---

## Real-World Analogies

### Singleton = Government ID Office
Only ONE office issues IDs. Everyone goes to the same place.

### Factory = Restaurant Kitchen
Order "Pizza" or "Pasta" - kitchen knows how to make each type without you specifying the recipe.

### Decorator = Pizza Toppings
Start with basic pizza, add cheese, add pepperoni, add mushrooms.
Each topping adds to the price.

### Observer = Newsletter Subscription
When news is published, all subscribers get notified automatically.

### Adapter = Power Plug Converter
US plug → Adapter → European socket. Different formats connected.

### Proxy = Security Guard
You ask guard to get document. Guard logs your request, then gets it.
