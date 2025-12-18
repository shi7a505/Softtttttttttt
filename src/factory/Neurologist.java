package factory;

public class Neurologist implements Doctor {
    @Override
    public String getSpecialization() {
        return "Neurologist";
    }
    
    @Override
    public String getDetails() {
        return "Specialization: Neurologist\n" +
               "Description: Brain and nervous system specialist\n" +
               "Expertise: Headaches, epilepsy, stroke, Alzheimer's, Parkinson's disease\n" +
               "Common Treatments: Neurological exams, EEG, brain imaging, medication management";
    }
}
