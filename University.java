import java.util.ArrayList;
import java.util.List;

abstract class University implements EducationalInstitution {
    public String name;
    public int studentCount;
    public double tuitionFee;
    public List<Student> students;

    University(String name, int studentCount, double tuitionFee) {
        this.name = name;
        this.studentCount = studentCount;
        this.tuitionFee = tuitionFee;
        this.students = new ArrayList<>();
    }

    public boolean transferStudent(Student student, University targetUniversity) {
        if (this.students.contains(student)) {
            if (student.getBalance() >= targetUniversity.tuitionFee) {
                this.students.remove(student);
                student.setBalance(student.getBalance() - targetUniversity.tuitionFee);
                targetUniversity.addStudent(student);
                student.setUniversity(targetUniversity);
                this.updateStudentCount();
                targetUniversity.updateStudentCount();
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
    public void updateStudentCount() {
        this.studentCount = this.students.size();
    }
    public void addStudent (Student student){
        this.students.add(student);
        this.studentCount = this.students.size();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}