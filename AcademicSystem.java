import java.util.ArrayList;
interface EducationalInstitution {
     String displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public ArrayList<Student> students;




    public boolean transferStudent(Student student, University toUniversity) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            this.studentCount--;
            toUniversity.students.add(student);
            toUniversity.studentCount++;
            student.setUniversity(toUniversity);
            return true;
        }
        return false;
    }

    University(String name, double tuitionFee) {
        this.name = name;
        this.tuitionFee = tuitionFee;
        this.students = new ArrayList<>();
        this.studentCount = 0;
    }
}

class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        setName(name);
        this.balance=balance;
        if(balance >= university.tuitionFee){
            this.university=university;
            university.students.add(this);
            university.studentCount++;
            this.balance -= university.tuitionFee;


        } else {System.out.println("Not enough balance");}

    }

    @Override
    public String displayInfo() {
        if (getUniversity() == null){return "Name: " + getName() + "\nUniversity: " + "Not Enrolled" + "\nBalance: " + getBalance();}
        else return "Name: " + this.name + "\nUniversity: " + getUniversity().name + "\nBalance: " + getBalance();
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
    public void  setUniversity(University toUniversity) {
            this.university=toUniversity;

    }
    public double getBalance() {
        return balance;
    }


}

class SbuUniversity extends University {
    public SbuUniversity(String name, double tuitionFee) {
        super(name,tuitionFee);
    }


    @Override
    public String displayInfo() {
        return "SBU University\nTuition Fee: " + String.format("%.1f", this.tuitionFee) + "\nStudent Count: " + this.studentCount;    }
}

class SutUniversity extends University {

    SutUniversity(String name, double tuitionFee) {
        super(name,tuitionFee);
    }



    @Override
    public String displayInfo() {
        return "SUT University\nTuition Fee: " + String.format("%.1f", this.tuitionFee) + "\nStudent Count: " + this.studentCount;

    }
}
public class AcademicSystem {
    public static void main(String[] args) {
        SbuUniversity sbu = new SbuUniversity("Shahid Beheshti University", 1500.0);
        SutUniversity sut = new SutUniversity("Sharif University of Technology", 2000.0);

        Student s1 = new Student("Ali", 3000.0, sbu);
        Student s2 = new Student("Sara", 1000.0, sut);

        System.out.println(s1.displayInfo());
        System.out.println(s2.displayInfo());

        System.out.println(sbu.displayInfo());
        System.out.println(sut.displayInfo());

        boolean transferred = sbu.transferStudent(s1, sut);
        if (transferred) {
            System.out.println("Student transferred successfully.");
        } else {
            System.out.println("Student transfer failed.");
        }

        System.out.println(s1.displayInfo());
        System.out.println(sbu.displayInfo());
        System.out.println(sut.displayInfo());
        
    }
}