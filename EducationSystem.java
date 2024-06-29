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
        if(this.students.contains(student)) {
            return false;
        }else {
            this.students.remove(student);
            university.students.add(student);
            student.university = university;
            university.studentCount++;
            this.studentCount--;
            return true;
        }
    }

    University(String name, double tuitionFee) {
        this.name = name;
        this.tuitionFee = tuitionFee;
        this.students = new ArrayList<>();
        this.studentCount = 0;
    }
    University(String name, double tuitionFee, Student student) {
        this.name = name;
        this.tuitionFee = tuitionFee;
        this.students = new ArrayList<>();
        this.students.add(student);
        this.studentCount++;
    }
}

class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        setName(name);
        setBalance(balance);
        if(university.tuitionFee <= getBalance()) {
            this.university = university;
            university.students.add(this);
            university.studentCount++;
        }else {
            System.out.println("Not Enough Balance");
        }
    }

    @Override
    public String displayInfo() {
        return "Name: " + getName() + "\nUniversity: " + getUniversity().name + "\nBalance: " + getBalance();
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
    public void setBalance(double balance) {
        this.balance = balance;
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
        return "SBU University\n" + "Tuition Fee: " + this.tuitionFee + "\nStudent Count: " + this.studentCount;
    }
}

class SutUniversity extends University {

    SutUniversity(String name, double tuitionFee) {
        super(name, tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SUT University\n" + "Tuition Fee: " + this.tuitionFee + "\nStudent Count: " + this.studentCount;
    }
}