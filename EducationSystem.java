import java.util.ArrayList;

interface EducationalInstitution {
    String displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public ArrayList<Student> students = new ArrayList<>();

    University(String name, double tuitionFee) {
        this.name = name;
        this.tuitionFee = tuitionFee;
    }

    public boolean transferStudent(Student student, University university) {
        if (students.contains(student)) {
            students.remove(student);
            university.students.add(student);
            student.university = university;
            studentCount--;
            university.studentCount++;
            return true;
        }
        return false;
    }

}


class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        this.name = name;
        if (balance >= university.tuitionFee) {
            this.balance = balance - university.tuitionFee;
            this.university = university;
            university.students.add(this);
            university.studentCount++;
        }
        else
            System.out.println("Not Enough Balance");

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

    public double getBalance() {
        return balance;
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
    public static void main(String[] args) {

        SbuUniversity sbu = new SbuUniversity("Shahid Beheshti University", 15);
        SutUniversity sut = new SutUniversity("Sharif University", 20);


        Student ali = new Student("Ali", 20, sbu);
        Student ali1 = new Student("Ali1", 20, sbu);
        Student ali2 = new Student("Ali2", 20, sbu);
        Student ali3 = new Student("Ali3", 20, sbu);
        Student maryam = new Student("Maryam", 1, sut);
        Student sara = new Student("Sara", 20, sut);


        System.out.println(sbu.displayInfo());
        System.out.println("\n" + sut.displayInfo());


        System.out.println("\n" + ali.displayInfo());
        System.out.println("\n" + sara.displayInfo());

        if (sbu.transferStudent(ali, sut))
            System.out.println("\nAli transferred to SUT successfully.");
        else
            System.out.println("\nAli's transfer failed.");


        System.out.println("\n" + sbu.displayInfo());
        System.out.println("\n" + sut.displayInfo());
        System.out.println("\n" + ali.displayInfo());
    }
}
