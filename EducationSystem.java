interface EducationalInstitution {
    void displayInfo();
}

import java.util.ArrayList;
import java.util.List;

abstract class University implements EducationalInstitution {
    protected String name;
    protected int studentCount;
    protected double tuitionFee;
    protected List<Student> students;

    public University(String name, int studentCount, double tuitionFee) {
        this.name = name;
        this.studentCount = studentCount;
        this.tuitionFee = tuitionFee;
        this.students = new ArrayList<>();
    }

    public boolean transferStudent(Student student, University toUniversity) {
        if (students.contains(student)) {
            students.remove(student);
            toUniversity.students.add(student);
            student.setUniversity(toUniversity);
            return true;
        }
        return false;
    }
}

class Student implements EducationalInstitution {
    private String name;
    private University university;
    private double balance;

    public Student(String name, double balance, University university) {
        this.name = name;
        this.balance = balance;

        if (balance >= university.tuitionFee) {
            this.university = university;
            university.students.add(this);
            this.balance -= university.tuitionFee;
        } else {
            System.out.println("Not Enough Balance");
        }
    }

    public String getName() {
        return name;
    }

    public University getUniversity() {
        return university;
    }

    public double getBalance() {
        return balance;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("University: " + university.name);
        System.out.println("Balance: " + balance);
    }
}

class SbuUniversity extends University {
    public SbuUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.printf("SBU University\nTuition Fee: %.1f\nStudent Count: %d\n", tuitionFee, students.size());
    }
}

class SutUniversity extends University {
    public SutUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.printf("SUT University\nTuition Fee: %.1f\nStudent Count: %d\n", tuitionFee, students.size());
    }
}

public class EducationSystem {
    public static void main(String[] args) {
        University sbu = new SbuUniversity("SBU", 0, 1000.0);
        University sut = new SutUniversity("SUT", 0, 2000.0);

        Student student1 = new Student("Alice", 1500.0, sbu);
        Student student2 = new Student("Bob", 2500.0, sut);

        student1.displayInfo();
        student2.displayInfo();

        sbu.displayInfo();
        sut.displayInfo();

        boolean transferred = sbu.transferStudent(student1, sut);
        System.out.println("Transfer Successful: " + transferred);

        sbu.displayInfo();
        sut.displayInfo();
        student1.displayInfo();
    }
}