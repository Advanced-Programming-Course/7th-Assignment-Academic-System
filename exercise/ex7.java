import java.util.ArrayList;
import java.util.List;

public class Main {

    interface EducationalInstitution {
        void displayInfo();
    }

    abstract class University implements EducationalInstitution {
        public String name;
        public int studentCount;
        public double tuitionFee;
        public ArrayList<Student> students;


        public boolean transferStudent(Student student, University aimUniversity) {
            if (this.students.contains(student)) {
                if (student.getBalance() >= aimUniversity.tuitionFee) {
                    this.students.remove(student);
                    student.setBalance(student.getBalance() -aimUniversity.tuitionFee);
                    aimUniversity.addStudent(student);
                    student.setUniversity(aimUniversity);
                    this.studentCount = this.students.size();
                    aimUniversity.newStudentCount();
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

        University(String name, int studentCount, double tuitionFee) {
            this.name = name;
            this.studentCount = studentCount;
            this.tuitionFee = tuitionFee;
            this.students = new ArrayList<>();
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        public void newStudentCount() { 
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
            this.name = name;
            this.balance = balance;
            if(balance >= university.tuitionFee){
                this.university = university;
            }
            else{
                this.university = null;
                System.out.println("Not Enough Balance");
            }
        }

        @Override
        public void displayInfo() {
            System.out.println("The Name is :" + name);
            System.out.println("The University is :" + university.name);
            System.out.println("The Balance is :" + balance);
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

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }
    }

    class SbuUniversity extends University {
        public SbuUniversity(String name, double tuitionFee, int studentCount) {
            super(name, tuitionFee, studentCount);
        }

        @Override
        public void displayInfo() {
            System.out.println("SBU University");
            System.out.println("The Tuition Fee is :" + tuitionFee);
            System.out.println("The Student Count is :" + studentCount);
        }
    }

    class SutUniversity extends University {
        SutUniversity(String name, double tuitionFee, int studentCount) {
            super(name, tuitionFee, studentCount);
        }

        @Override
        public void displayInfo() {
            System.out.println("SUT University");
            System.out.println("The Tuition Fee is :" + tuitionFee);
            System.out.println("The Student Count is :" + studentCount);
        }
    }

    public static void main(String[] args) {

        SbuUniversity Sbu = new SbuUniversity("Shahid Beheshti", 1000, 250);
        SutUniversity Sut = new SutUniversity("Sana'ti Sharif", 3000, 100);
        Sbu.setTargetUniversity(Sut);
        Sut.setTargetUniversity(Sbu);

        Student sbuStudent = new Student("Ali", 300, Sbu);
        Student sutStudent = new Student("Sara", 90, Sut);

        List<Student> sbuStudents = new ArrayList<>();
        sbuStudents.add(sbuStudent);
        Sbu.setStudents(sbuStudents);

        List<Student> sutStudents = new ArrayList<>();
        sutStudents.add(sutStudent);
        Sut.setStudents(sutStudents);

        System.out.println("Before transfer:");
        sbuStudent.displayInfo();
        sutStudent.displayInfo();
        Sbu.displayInfo();
        Sut.displayInfo();

        System.out.println("After transfer:");
        sbuStudent.displayInfo();
        sutStudent.displayInfo();
        Sbu.displayInfo();
        Sut.displayInfo();
    }
}