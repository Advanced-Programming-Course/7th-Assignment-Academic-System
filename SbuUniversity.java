class SbuUniversity extends University {
    public SbuUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("SBU University");
        System.out.println("Tuition Fee: " +  tuitionFee);
        System.out.println("Student Count: " + studentCount);
    }

    public void setTargetUniversity(SutUniversity sut) {
    }
}
