import java.util.ArrayList;
interface EducationalInstitution {
    String displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public ArrayList<Student> students;

    public University(String name , int studentCount , double tuitionFee , ArrayList<Student> students){
        this.name = name ;
        this.studentCount=studentCount;
        this.tuitionFee=tuitionFee;
        this.students=students;
    }

    public boolean transferStudent(Student student, University university) {
        if(students.contains(student)){
            this.students.remove(student);
            university.students.add(student);
            student.setUniversity(university);
            this.studentCount=studentCount-1;
            university.studentCount++;
            return true;
        }
        else{
            return false;
        }
    }

    University(String name, double tuitionFee) {
        this.name = name ;
        this.studentCount=0;
        this.tuitionFee=tuitionFee;
        this.students=new ArrayList<>();
    }

    @Override
   public abstract String displayInfo();
}

class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        this.name = name;
        this.balance = balance;
        if (balance >= university.tuitionFee) {
            this.university = university;
            university.students.add(this);
            this.balance=balance - university.tuitionFee;
            university.studentCount++;
        }
        else{
            System.out.println("\"Not Enough Balance\" ");
        }
    }

    @Override
    public String displayInfo() {
        return "Name: " + this.name + "\nUniversity: "+ this.university.name + "\nBalance: "+ this.balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university){
        this.university=university;

    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;

    }
}

class SbuUniversity extends University {
    public SbuUniversity(String name, double tuitionFee) {
        super(name , tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SBU University \nTuition Fee: " + String.format("%.1f",this.tuitionFee) + "\nStudent Count: " + this.studentCount;
    }
}

class SutUniversity extends University {

    SutUniversity(String name, double tuitionFee) {
        super( name , tuitionFee);
    }

    @Override
    public String displayInfo() {
        return "SUT University \nTuition Fee: " + String.format("%.1f",this.tuitionFee) + "\nStudent Count: " + this.studentCount;

    }
}

//============================================================================================================================================
// اضافه کردن تابع  main  برای چک کردن کد:
public class EducationSystem{
    public static void main(String[] args) {
        SbuUniversity sbuUniversity = new SbuUniversity("Sbu University", 5000.0);
        SutUniversity sutUniversity = new SutUniversity("SUT University", 7000.0);
        Student s1 = new Student("Kamran", 10000.0, sbuUniversity);
        Student s2 = new Student("Hooman", 10000.0, sutUniversity);
        System.out.println(s1.displayInfo());
        System.out.println(s2.displayInfo());
        if (sbuUniversity.transferStudent(s1, sbuUniversity)) {
            System.out.println("transfer of " + s1.getName() + ": ");
            System.out.println(sbuUniversity.transferStudent(s1, sutUniversity));
        } else {
            System.out.println("transfer of " + s1.getName() + ": ");
            System.out.println(sbuUniversity.transferStudent(s1, sutUniversity));
        }

        if (sutUniversity.transferStudent(s2, sbuUniversity)) {
            System.out.println("transfer of " + s2.getName() + ": ");
            System.out.println(sutUniversity.transferStudent(s2, sbuUniversity));
        } else {
            System.out.println("transfer of " + s2.getName() + ": ");
            System.out.println(sutUniversity.transferStudent(s2, sbuUniversity));
        }

        System.out.println(sbuUniversity.displayInfo());
        System.out.println(sutUniversity.displayInfo());
    }
}
