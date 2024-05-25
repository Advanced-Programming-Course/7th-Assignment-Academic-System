import java.util.ArrayList;

interface EducationalInstitution {
    String displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name ;
    public int studentCount;
    public double tuitionFee;
    public ArrayList<Student> students = new ArrayList<>();

    public University(String name, double tuitionFee) {
        this.name = name;
        this.tuitionFee = tuitionFee;
    }

    public boolean transferStudent(Student student, University university) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            university.students.add(student);
            student.university = university;
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
        if (balance >= university.tuitionFee) {
            this.name = name;
            this.balance = balance - university.tuitionFee;
            this.university = university;
            university.students.add(this);
        } else {
            System.out.println("Not Enough Balance");
        }
    }

    @Override
    public String displayInfo() {
        return "Name: " + this.name + "\nUniversity: " + this.university.name + "\nBalance: " + this.balance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return this.university;
    }

    public double getBalance() {
        return this.balance;
    }
}

class SbuUniversity extends University {
    public SbuUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SBU University\nTuition Fee: " + String.format("%.1f", this.tuitionFee) + "\nStudent Count: "
                + this.students.size();
    }
}

class SutUniversity extends University {
    public SutUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SUT University\nTuition Fee: " + String.format("%.1f", this.tuitionFee) + "\nStudent Count: "
                + this.students.size();
    }
}

public class EducationSystem {
    public static void main(String[] args) {

        SbuUniversity sbu = new SbuUniversity("SBU", 10000.0);
        SutUniversity sut = new SutUniversity("SUT", 12000.0);

        Student student1 = new Student("Ali", 15000.0, sbu);
        Student student2 = new Student("Reza", 13000.0, sut);

        // Display student info
        System.out.println(student1.displayInfo());
        System.out.println(student2.displayInfo());

        if (sbu.transferStudent(student1, sut)) {
            System.out.println("Student transferred successfully.");
        } else {
            System.out.println("Student transfer failed.");
        }

        System.out.println(student1.displayInfo());
        System.out.println(student2.displayInfo());
    }
}
