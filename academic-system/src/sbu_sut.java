public class sbu_sut {
    interface Universities {
        void displayInfo();
    }

    abstract class University implements Universities {
        protected String name;
        protected int studentCount;
        protected double tuitionFee;
        protected Student[] students;

        public University(String name, int studentCount, double tuitionFee) {
            this.name = name;
            this.studentCount = studentCount;
            this.tuitionFee = tuitionFee;
            this.students = new
                    Student[studentCount];
        }

        public abstract void
        transferStudent(University destinationUniversity);

        @java.lang.Override
        public void displayInfo() {
            System.out.println("Uni name:" + name);
            System.out.println("Student Count:" + studentCount);
            System.out.println("Tuition Fee" + tuitionFee);
        }
    }

    class Student implements Universities {
        private String name;
        private University university;
        private double balance;

        public Student(String name, double balance, University university) {
            this.name = name;
            this.balance = balance;

            if (balance >= university.tuitionFee) {
                this.university = university;
                this.balance -= university.tuitionFee;
            } else {
                System.out.println(" HONEY ; The balance is not Enough ");
            }
        }

        @java.lang.Override
        public void displayInfo() {
            System.out.println(" Name: " + name);
            System.out.println(" University: " + university.name);
            System.out.println(" Balance: " + balance);
        }

        public String getName() {
            return name;
        }

        public University getUniversity() {
            return university;
        }

        public double getBalance() {
            return balance;
        }
    }

    abstract class SbuUniversity extends University {
        public SbuUniversity(String name, int studentCount, double tuitionFee) {
            super(name, studentCount, tuitionFee);
        }

        @java.lang.Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("SBU Uni");
            System.out.println("tuitiom fee:" + String.format("% 1f", tuitionFee));
            System.out.println("Student count:" + studentCount);
        }
    }

    abstract class SutUniversity extends University {
        public SutUniversity(String name, int studentCount, double tuitionFee) {
            super(name, studentCount, tuitionFee);
        }

        @java.lang.Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("SUT Uni");
            System.out.println("tuitiom fee:" + String.format("% 1f", tuitionFee));
            System.out.println("Student count:" + studentCount);
        }
    }
}