package factory;

public class Cardiologist implements Doctor {
    @Override
    public String getSpecialization() {
        return "Cardiologist";
    }
    
    @Override
    public String getDetails() {
        return "Specialization: Cardiologist\n" +
               "Description: Heart and cardiovascular system specialist\n" +
               "Expertise: Heart disease, blood pressure, ECG, cardiac surgery\n" +
               "Common Treatments: Angioplasty, pacemaker implantation, cardiac catheterization";
    }
}
