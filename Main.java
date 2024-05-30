import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SbuUniversity sbu = new SbuUniversity("SBU", 0, 1000);
        SutUniversity sut = new SutUniversity("SUT", 0, 1200);
        sbu.setTargetUniversity(sut);
        sut.setTargetUniversity(sbu);

        Student sbuStudent = new Student("John Doe", 1500, sbu);
        Student sutStudent = new Student("Jane Smith", 2000, sut);

        List<Student> sbuStudents = new ArrayList<>();
        sbuStudents.add(sbuStudent);
        sbu.setStudents(sbuStudents);

        List<Student> sutStudents = new ArrayList<>();
        sutStudents.add(sutStudent);
        sut.setStudents(sutStudents);

        System.out.println("Before transfer:");
        sbuStudent.displayInfo();
        sutStudent.displayInfo();
        sbu.displayInfo();
        sut.displayInfo();

        System.out.println("\nTransferring student from SBU to SUT:");
        boolean success1 = sbu.transferStudent(sbuStudent, sut);
        boolean success2 = sut.transferStudent(sutStudent, sbu);
        System.out.println("Transfer success: " + success1);
        System.out.println("Transfer success: " + success2);

        System.out.println("\nAfter transfer:");
        sbuStudent.displayInfo();
        sutStudent.displayInfo();
        sbu.displayInfo();
        sut.displayInfo();
    }
}