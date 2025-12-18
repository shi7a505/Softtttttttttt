package factory;

public class GeneralPractitioner implements Doctor {
    @Override
    public String getSpecialization() {
        return "General Practitioner";
    }
    
    @Override
    public String getDetails() {
        return "Specialization: General Practitioner\n" +
               "Description: Primary care physician for general health issues\n" +
               "Expertise: Common illnesses, preventive care, routine check-ups, vaccinations\n" +
               "Common Treatments: Physical exams, prescriptions, health counseling, referrals";
    }
}
