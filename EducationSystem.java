import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        // ایجاد دو دانشگاه
//        University sbu = new SbuUniversity("SBU", 5000);
//        University sut = new SutUniversity("SUT", 4000);
//
//        // ایجاد دانشجوها
//        Student student1 = new Student("Ali", 6000, sbu);
//        Student student2 = new Student("Sara", 3000, sut);
//        Student student3 = new Student("Reza", 5000, sut);
//        Student student4 = new Student("Mina", 4500, sbu);
//        Student student5 = new Student("Nima", 7000, sbu);
//        Student student6 = new Student("Laleh", 3500, sut);
//        Student student7 = new Student("Hassan", 4800, sbu);
//        Student student8 = new Student("Elham", 5200, sut);
//
//        // نمایش اطلاعات دانشجویان
//        System.out.println(student1.displayInfo());
//        System.out.println("------------------");
//        System.out.println(student3.displayInfo());
//        System.out.println("------------------");
//        System.out.println(student5.displayInfo());
//        System.out.println("------------------");
//        System.out.println(student8.displayInfo());
//        System.out.println("------------------");
//
//        // نمایش اطلاعات دانشگاه‌ها
//        System.out.println(sbu.displayInfo());
//        System.out.println("------------------");
//        System.out.println(sut.displayInfo());
//        System.out.println("------------------");
//
//        // انتقال دانشجو از SBU به SUT
//        System.out.println("Transferring Ali from SBU to SUT...");
//        boolean transferResult = sbu.transferStudent(student1, sut);
//        System.out.println("Transfer Successful: " + transferResult);
//
//        // نمایش اطلاعات دانشگاه‌ها بعد از انتقال
//        System.out.println(sbu.displayInfo());
//        System.out.println("------------------");
//        System.out.println(sut.displayInfo());
//        System.out.println("------------------");
//
//        // نمایش اطلاعات دانشجویان بعد از انتقال
//        System.out.println(student1.displayInfo());
//        System.out.println("------------------");
//        System.out.println(student3.displayInfo());
//        System.out.println("------------------");
//        System.out.println(student5.displayInfo());
//        System.out.println("------------------");
//        System.out.println(student8.displayInfo());
//        System.out.println("------------------");
//    }
//}

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