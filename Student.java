public class Student implements EducationalInstitution{
    private String name;
    public University university;
    private double balance;

    Student(String name, double myBalance, University university) {
        this.name = name;
        this.balance = myBalance;
        if (balance >= university.tuitionFee) {
            this.university = university;
            university.students.add(this);
            this.balance -= university.tuitionFee;
            university.studentCount++;
        }
        else {
            System.out.println("Not Enough Balance");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: "+ name);
        System.out.println("University: "+ university.name);
        System.out.println("Balance: "+ balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
