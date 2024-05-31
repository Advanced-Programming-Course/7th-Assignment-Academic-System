import java.util.ArrayList;

interface EducationalInstitution {
    String displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public ArrayList<Student> students;

    public boolean transferStudent(Student student, University university) {
        if(students.contains(student) == true){
            students.remove(student);
            studentCount--;
            student.setUniversity(university);
            university.students.add(student);
            university.studentCount++;
            return true;
        }
        return false;
    }
    
    University(String name, double tuitionFee) {
        this.name = name;
        this.studentCount = 0;
        this.tuitionFee = tuitionFee;
        this.students = new ArrayList<>();
    }

}

class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        if(balance >= university.tuitionFee){
            this.name = name;
            this.balance = balance - university.tuitionFee;
            this.university = university;
            university.students.add(this);
            university.studentCount++;
        }
        else {
            System.out.println("Not Enough Balance");
        }
    }

    @Override
    public String displayInfo() {
        return "Name: " + name + " | University: " + university.name + " | Balance: " + balance;
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
        return "SBU University:\nTuition Fee: " + String.format("%.1f", tuitionFee) + " | Student Count: " + studentCount;
    }
}

class SutUniversity extends University {

    public SutUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SUT University:\nTuition Fee: " + String.format("%.1f", tuitionFee) + " | Student Count: " + studentCount;
    }
}


public class EducationSystem {
    public static void main(String[] args){
        // tests
        SbuUniversity sbu = new SbuUniversity("SBU", 1000);
        SutUniversity sut = new SutUniversity("SUT", 1200);
        System.out.println(sbu.displayInfo());
        System.out.println(sut.displayInfo());
        Student sbuStudent = new Student("Hasan", 1500, sbu);
        Student sutStudent1 = new Student("Shima", 1500, sut);
        Student sutStudent2 = new Student("Setareh", 100, sut);
        System.out.println("---------------------------");
        System.out.println("Before transfer:");
        System.out.println(sbu.displayInfo());
        System.out.println(sut.displayInfo());
        System.out.println(sbuStudent.displayInfo());
        System.out.println(sutStudent1.displayInfo());
        System.out.println("---------------------------");
        boolean Done = sbu.transferStudent(sbuStudent, sut);
        System.out.println("Transfer = " + Done);
        System.out.println("---------------------------");
        System.out.println("After transfer:");
        System.out.println(sbu.displayInfo());
        System.out.println(sut.displayInfo());
        System.out.println(sbuStudent.displayInfo());
        System.out.println(sutStudent1.displayInfo());

    }
}
