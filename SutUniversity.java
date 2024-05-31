public class SutUniversity extends University{


    SutUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("SUT University\n");
        System.out.println("Tuition Fee: "+ tuitionFee);
        System.out.println("Student Count: "+ studentCount);
    }
}
