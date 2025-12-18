package factory;

public class DoctorFactory {
    public static Doctor createDoctor(String specialization) {
        if (specialization == null) {
            return null;
        }
        
        switch (specialization) {
            case "Cardiologist":
                return new Cardiologist();
            case "Neurologist":
                return new Neurologist();
            case "General Practitioner":
                return new GeneralPractitioner();
            default:
                return null;
        }
    }
}
