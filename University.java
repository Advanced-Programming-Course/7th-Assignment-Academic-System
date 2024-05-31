import java.util.ArrayList;

abstract class University {
    String name;
    int studentCount;
    double tuitionFee;
    ArrayList<Student> students;

    University(String name, int studentCount, double tuitionFee, ArrayList<Student> students) {
        this.name = name;
        this.tuitionFee = tuitionFee;
        this.students = students;
        this.studentCount = studentCount;
    }

    public University(String name, double tuitionFee) {
        this.name = name;
        this.tuitionFee = tuitionFee;
        this.studentCount = 0;
        this.students = new ArrayList<>();
    }

    public boolean transferStudent(Student student,University goalUniversity) {
        if (students.contains(student)) {
            students.remove(student);
            goalUniversity.students.add(student);
            student.setUniversity(goalUniversity);
            studentCount--;
            goalUniversity.studentCount++;
            return true;
        }
        else {
            return false;
        }
    }

    public abstract void displayInfo();
}
