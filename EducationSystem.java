import java.util.ArrayList;
interface EducationalInstitution {
    String displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public ArrayList<Student> students;
    public University(String name,int studentCount,double tuitionFee,ArrayList<Student> students){
        this.name = name;
        this.studentCount = studentCount;
        this.tuitionFee = tuitionFee;
        this.students =students;
    }

    public boolean transferStudent(Student student, University university) {
        if(student.contains(student)){
            student.remove(student);
            university.students.add(student);
            student.setUniversity(university);
            studentCount--;
            university.studentCount++;
            return true;
        }
        else {
            return false;
        }
    }

    University(String name, double tuitionFee) {
        this.name = name;
        this.studentCount = 0;
        this.tuitionFee = tuitionFee;
        this.students =  new ArrayList<>();
    }
    @Override
    public abstract String dislayInfo();

}

class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        this.name = name;
        this.balance = balance;
        if(balance >= university.tuitionFee){
            this.university = university;
            university.students.add(this);
            university.studentCount++;
            this.balance -= university.tuitionFee;
        } else {
            System.out.println("Not Enough Balance");
        }
    }

    @Override
    public String displayInfo() {
        return "Name: " + name + "\nUniversity: " + university.name + "\nBalance: " + balance;
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

class SbuUniversity extends University {
    public SbuUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SBU University\nTuition Fee: " + String.format("%.1f", tuitionFee) + "\nStudent Count: " + studentCount;
    }
}

class SutUniversity extends University {


    SutUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SUT University\nTuition Fee: " + String.format("%.1f", tuitionFee) + "\nStudent Count: " + studentCount;

    }
}
public class EducationSystem {
    public class void main(String[] args){
        University sbu = new SbuUniversity("SBU", 7000.0);
        University sut = new SutUniversity("SUT", 6000.0);
        Student studentA = new Student("Sara", 5000.0, sbu);
        Student studentB = new Student("Raha", 6500.0, sut);
        System.out.println(studentA.displayInfo());
        System.out.println(studentB.displayInfo());
        System.out.println(sbu.displayInfo());
        System.out.println(sut.displayInfo());
        boolean transferOfStudent = sbu.transferStudent(studentA,sut);
        System.out.println(transferOfStudent);
        System.out.println(studentA.displayInfo());
        System.out.println(sbu.displayInfo());
        System.out.println(sut.displayInfo());

    }
}
