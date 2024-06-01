import java.util.ArrayList;
import java.util.list;
interface EducationalInstitution {
    String displayInfo();
}

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public ArrayList<Student> students;

    public boolean transferStudent(Student student, University nextUniversity) {
        if (this.students.contains(student)){
            if (student.getBalance() >= nextUniversity.tuitionfee){
                this.student.remove(student);
                student.setBalance(student.getBalance() - nextUniversity.tuitionfee);
                nextUniversity.addstudent(student);
                student.setUniversity(nextUniversity);
                this.studentCount = this.students.size();
                aimUniversity.newStudentCount();
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

        
    

    University(String name, double tuitionFee , int studentcount) {
        this.name=name;
        this.tuitionfee=tuitionfee;
        this.studentCount=studentcount;
        this.students=new ArrayList<>();
    }


    public void setStudents(List<Student> student){
        this.students=students;
    }

    public void newStudentcount(){
         this.studentCount = this.students.size();
    }

     public void addStudent(Student student){
                this.students.add(student);
                this.studentCount = this.students.size();
    }
}


    

class Student implements EducationalInstitution {
    private String name;
    public University university;
    private double balance;

    public Student(String name, double balance, University university) {
        this.name=name;
        this.balance=balance;
        if(balance>=university.tuitionfee){
            this.university=university;
        }
        else{
            this.university=null;
            System.out.println("not qualified");
        }
    }

    @Override
    public String displayInfo() {
         System.out.println(name);
         System.out.println(university.name);
         System.out.println(balance);
        
        
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
        this.balance=balace;
    }
}

class SbuUniversity extends University {
    public SbuUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionfee);
    }

    @Override
    public void displayInfo() {
    System.out.println("shahid beheshti");
    System.out.println(tuitionFee);
    System.out.println(studentCount);
        
    }
}

class SutUniversity extends University {
     SutUniversity(String name, int studentCount, double tuitionFee) {
        super(name, studentCount, tuitionFee);

    @Override
    public String displayInfo() {
        System.out.println("sharif");
        System.out.println(tuitionFee);
        System.out.println(studentCount);

    }
}
