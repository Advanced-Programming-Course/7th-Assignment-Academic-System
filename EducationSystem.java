import java.util.ArrayList;
import java.util.Random;

// An interface that lets us tell if an educational place shows its info properly
interface EducationalInstitution {
    // Every educational place needs to show its details somehow
    String displayInfo();
}

// An abstract class for a university, which is a kind of educational place
abstract class University implements EducationalInstitution {
    // Stuff we need to know about the university
    public String uniName;
    public int numStudents;
    public double annualFee;
    public ArrayList<Student> enrolledStudents;

    // Helps move a student from one university to another
    public boolean transferStudent(Student student, University destUni) {
        if (enrolledStudents.contains(student)) { // Check if the student is here
            enrolledStudents.remove(student); // Kick 'em outta here
            numStudents--; // One less student
            destUni.enrolledStudents.add(student); // Welcome them over there
            destUni.numStudents++; // One more student over there
            return true; // Transfer went smoothly
        }
        return false; // Something went wrong
    }

    // Makes a new university
    University(String uniName, double annualFee) {
        this.uniName = uniName;
        this.annualFee = annualFee;
        enrolledStudents = new ArrayList<>(); // Starting empty
        numStudents = 0; // No students yet
    }
}

// Represents a student who goes to a university
class Student implements EducationalInstitution {
    // Stuff about the student
    private String studentName;
    public University attendingUni; // Where the student goes to school
    private double cashOnHand; // How much money the student has

    // Makes a new student
    public Student(String studentName, double cashOnHand, University attendingUni) {
        this.studentName = studentName;
        this.cashOnHand = cashOnHand;
        this.attendingUni = attendingUni;

        // Check if the student can afford the university
        if (cashOnHand >= attendingUni.annualFee) {
            attendingUni.enrolledStudents.add(this); // Add 'em to the list
            attendingUni.numStudents++; // One more student
            cashOnHand -= attendingUni.annualFee; // Pay the fees
        } else {
            System.out.println("Not enough money."); // Can't afford it
        }
    }

    // Shows the student's info in a nice format
    @Override
    public String displayInfo() {
        if (attendingUni == null) { // Not going to any university
            return "Name: " + studentName + "\nGoing to School: None\nMoney Left: " + cashOnHand;
        } else {
            return "Name: " + studentName + "\nGoing to School: " + attendingUni.uniName + "\nMoney Left: "
                    + cashOnHand;
        }
    }

    // Gets the student's info
    public String getStudentName() {
        return studentName;
    }

    public University getSchool() {
        return attendingUni;
    }

    public double getMoneyLeft() {
        return cashOnHand;
    }
}

// Specific kinds of universities
class SbuUniversity extends University {
    public SbuUniversity(String uniName, double annualFee) {
        super(uniName, annualFee);
    }

    @Override
    public String displayInfo() {
        return "SBU University\nAnnual Fee: " + String.format("%.1f", annualFee) + "\nNumber of Students: "
                + numStudents;
    }
}

class SutUniversity extends University {
    public SutUniversity(String uniName, double annualFee) {
        super(uniName, annualFee);
    }

    @Override
    public String displayInfo() {
        return "SUT University\nAnnual Fee: " + String.format("%.1f", annualFee) + "\nNumber of Students: "
                + numStudents;
    }
}

// Main class to see everything in action

class EduSystem {
    public static void main(String[] args) {
        // Let's start by picking random names and prices for our universities
        Random rand = new Random();
        String sbuName = "Shahid Beheshti University";
        double sbuPrice = 1300.0 + rand.nextDouble() * 500; // Between 1500 and 2000
        String sutName = "Sharif University of Technology";
        double sutPrice = 2200.0 + rand.nextDouble() * 500; // Between 2000 and 2500

        // Now, let's enroll some students with varying amounts of cash
        String s1Name = "Mehdi";
        double s1Cash = 3000.0 + rand.nextDouble() * 2000; // Between 3000 and 5000
        String s2Name = "Sara";
        double s2Cash = 1000.0 + rand.nextDouble() * 1000; // Between 1000 and 2000

        // Displaying the initial setup
        System.out.println("Welcome to our academic world!");
        System.out.println("Our universities:");
        System.out.println("SBU University - Annual Fee: " + sbuPrice);
        System.out.println("SUT University - Annual Fee: " + sutPrice);

        // Enrolling students
        System.out.println("\nEnrolling students...");
        Student s1 = new Student(s1Name, s1Cash, sbuPrice <= s1Cash ? new SbuUniversity(sbuName, sbuPrice) : null);
        Student s2 = new Student(s2Name, s2Cash, sutPrice <= s2Cash ? new SutUniversity(sutName, sutPrice) : null);

        // Displaying student info
        System.out.println("\nMeet our students:");
        System.out.println(s1.displayInfo());
        System.out.println(s2.displayInfo());

        // transfer a student
        boolean didTransfer = s1.getSchool() != null && s1.getSchool().transferStudent(s1, s2.getSchool());
        if (didTransfer) {
            System.out.println("\nWow, " + s1Name + " decided to switch to " + s2Name + "'s university!");
            System.out.println(s1.displayInfo());
            System.out.println(s2.displayInfo());
        } else {
            System.out.println("\nLooks like " + s1Name + " couldn't make the switch.");
        }
    }
}
