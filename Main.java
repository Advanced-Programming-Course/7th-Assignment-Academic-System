import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        University sbu = new SbuUniversity("Sbu",5000.0);
        University sut = new SutUniversity("Sut",6000.0);

        Student student1 = new Student("Arian",5000.0,sbu);
        Student student2 = new Student("Amir",8000.0,sut);

        sbu.displayInfo();
        System.out.println("--------------");
        sut.displayInfo();

        System.out.println("--------------");
        student1.displayInfo();
        student2.displayInfo();

        sbu.transferStudent(student1,sut);

        System.out.println("--------------"); // after transferring 1 student
        student1.displayInfo();
        System.out.println("--------------");
        sut.displayInfo();
        System.out.println("--------------");


        sut.transferStudent(student2,sbu); // transferring the second student
        student2.displayInfo();
        System.out.println("--------------");
        sbu.displayInfo();
    }
}