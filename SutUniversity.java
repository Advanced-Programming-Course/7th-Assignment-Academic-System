class SutUniversity extends University {

    SutUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("SUT University");
        System.out.println("Tuition Fee: " +  tuitionFee);
        System.out.println("Student Count: " + studentCount);

    }

    public void setTargetUniversity(SbuUniversity sbu) {
    }
}