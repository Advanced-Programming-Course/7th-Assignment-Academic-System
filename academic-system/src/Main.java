//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        sbu_sut.SbuUniversity sbu = new sbu_sut.SbuUniversity ("SBU" , 2000 , 4000.0);
        sbu_sut.SutUniversity sut = new sbu_sut.SutUniversity ("SUT", 2500 , 3000.0);
        sbu_sut.Student student1 = new sbu_sut.Student("abas", 6000.0 , sbu);
        sbu_sut.Student student2 = new sbu_sut.Student("soghra", 2000.0 , sbu);

        student1.displayInfo();
        System.out.println();

        student2.displayInfo();
        System.out.println();

        sbu.transferStudent(sut);

        student1.displayInfo();
        System.out.println();

        student2.displayInfo();
        System.out.println();

        sut.displayInfo();
        }
}