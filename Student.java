class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        this.name = name;
        this.balance = balance;
        if (balance >= university.tuitionFee) {
            this.university = university;
        }
        else {
            System.out.println("Not Enough Balance");
            this.university = null;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("University: " + university.name);
        System.out.println("Balance: " + balance);
    }

    public String getName() {
        return name;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setUniversity(University university){
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public double getBalance() {
        return balance;
    }
}