import java.util.ArrayList;
import java.util.List;
interface EducationalInstitution {
    void displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public List<Student> students;

    University(String name, int studentCount, double tuitionFee) {
        this.name = name;
        this.studentCount = studentCount;
        this.tuitionFee = tuitionFee;
        this.students = new ArrayList<>();
    }

    public boolean transferStudent(Student student, University targetUniversity) {
        if (this.students.contains(student)) {
            if (student.getBalance() >= targetUniversity.tuitionFee) {
                this.students.remove(student);
                student.setBalance(student.getBalance() - targetUniversity.tuitionFee);
                targetUniversity.newStudent(student);
                student.setUniversity(targetUniversity);

                this.newStudentCount();
                targetUniversity.newStudentCount();
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public void newStudentCount() {
        this.studentCount = this.students.size();
    }
    public void newStudent(Student student){
        this.students.add(student);
        this.studentCount = this.students.size();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    // constructor
    public Student(String name, double balance, University university) {
        this.name = name;
        this.balance = balance;
        // if student has enough money
        if (balance >= university.tuitionFee) {
            this.university = university;
        }
        else {
            System.out.println("transfer failed");
            this.university = null;
        }
    }

    // interface override
    @Override
    public void displayInfo() {
        System.out.println(name);
        System.out.println(university.name);
        System.out.println(balance);
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

class SbuUniversity extends University {
    public SbuUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("SBU");
        System.out.println(tuitionFee);
        System.out.println(studentCount);
    }
}

class SutUniversity extends University {
    SutUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("SUT");
        System.out.println(tuitionFee);
        System.out.println(studentCount);

    }
}
