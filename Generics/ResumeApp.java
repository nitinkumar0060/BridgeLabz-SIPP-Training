import java.util.*;

abstract class JobRole {
    private String candidateName;
    public JobRole(String candidateName) { this.candidateName = candidateName; }
    public String getCandidateName() { return candidateName; }
    public abstract void evaluateResume();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) { super(candidateName); }
    public void evaluateResume() {
        System.out.println(getCandidateName() + " evaluated for Software Engineer role.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) { super(candidateName); }
    public void evaluateResume() {
        System.out.println(getCandidateName() + " evaluated for Data Scientist role.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) { super(candidateName); }
    public void evaluateResume() {
        System.out.println(getCandidateName() + " evaluated for Product Manager role.");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;
    public Resume(T jobRole) { this.jobRole = jobRole; }
    public T getJobRole() { return jobRole; }
    public void process() { jobRole.evaluateResume(); }
}

class ResumeProcessor {
    public static void screenResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.evaluateResume();
        }
    }
}

public class ResumeApp {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>(new SoftwareEngineer("Amit"));
        Resume<DataScientist> r2 = new Resume<>(new DataScientist("Priya"));
        Resume<ProductManager> r3 = new Resume<>(new ProductManager("Rahul"));

        List<JobRole> pipeline = new ArrayList<>();
        pipeline.add(r1.getJobRole());
        pipeline.add(r2.getJobRole());
        pipeline.add(r3.getJobRole());

        ResumeProcessor.screenResumes(pipeline);
    }
}
