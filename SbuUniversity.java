public class SbuUniversity extends University implements EducationalInstitution{


    SbuUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("SBU University\n");
        System.out.println("Tuition Fee: "+ tuitionFee);
        System.out.println("Student Count: "+ studentCount);
    }
}
