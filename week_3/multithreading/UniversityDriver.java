package week_3.multithreading;

class Height {
    int feet;
    int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    @Override
    public String toString() {
        return "Height=" + feet + "feet " + inches + " inches";
    }

}

abstract class Student {
    String name;
    Height height;
    String branch;

    Student() {
    }

    public Student(String name, Height height) {
        this.name = name;
        this.height = height;

    }

    public static int compareByHeight(Student s1, Student s2) {
        if (s1.height.feet > s2.height.feet) {
            return 1;
        } else if (s1.height.feet < s2.height.feet) {
            return -1;
        } else {
            if (s1.height.inches < s2.height.inches) {
                return -1;
            } else if (s1.height.inches > s2.height.inches) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    @Override
    public String toString() {
        return "Student [branch=" + branch + ", " + height + ", name=" + name + "]";
    }

}

class EEEStudent extends Student {
    EEEStudent() {

    }

    public EEEStudent(String name, Height height) {
        super(name, height);
        this.branch = "EEE";
    }
}

class ECEStudent extends Student {
    public ECEStudent(String name, Height height) {
        super(name, height);
        this.branch = "ECE";
    }

}

class CSEStudent extends Student {
    public CSEStudent(String name, Height height) {
        super(name, height);
        this.branch = "CSE";
    }

}

class StudentAdministration {
    Student[] students;

    StudentAdministration(Student[] students) {
        this.students = students;
    }

    public void sortByHeight() {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (Student.compareByHeight(students[i], students[j]) < 1) {
                    Student tmp = students[i];
                    students[i] = students[j];
                    students[j] = tmp;

                }
            }
        }
    }

    public Student[] getStudentByDepartment(String Department, Student[] students) {
        Student[] student = new Student[2];
        int i = 0;
        for (Student stu : students) {
            if (stu.branch.equals(Department))
                student[i++] = stu;
        }
        return student;
    }

    public void displaySortedEEEStudents() {
        Student[] eeestu = getStudentByDepartment("EEE", students);
        int idx = 0;
        synchronized (this) {
            while (idx < eeestu.length) {
                System.out.println(eeestu[idx++]);
                notifyAll();
            }
        }

    }

    public void displaySortedECEStudents() {
        Student[] ecestu = getStudentByDepartment("ECE", students);

        int idx = 0;
        synchronized (this) {
            while (idx < ecestu.length) {
                System.out.println(ecestu[idx++]);
                try {
                    if (idx < 1)
                        wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // notifyAll();

            }
        }
    }

    public void displaySortedCSEStudents() {
        Student[] csestu = getStudentByDepartment("CSE", students);
        int idx = 0;
        synchronized (this) {
            while (idx < csestu.length) {
                System.out.println(csestu[idx++]);
                try {
                    if (idx < 1)
                        wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // notifyAll();

            }
        }
    }

}

public class UniversityDriver {
    public static void main(String[] args) {
        EEEStudent s1 = new EEEStudent("Harsh", new Height(5, 5));
        EEEStudent s2 = new EEEStudent("Shivam", new Height(5, 7));
        CSEStudent s3 = new CSEStudent("Sagar", new Height(5, 8));
        CSEStudent s4 = new CSEStudent("Karan", new Height(5, 11));
        ECEStudent s5 = new ECEStudent("Roger", new Height(5, 10));
        ECEStudent s6 = new ECEStudent("Sakshi", new Height(5, 9));
        Student student[] = new Student[] { s1, s2, s3, s4, s5, s6 };
        StudentAdministration admin = new StudentAdministration(student);
        admin.sortByHeight();
        Thread cseDept = new Thread() {
            public void run() {
                admin.displaySortedCSEStudents();
            }
        };
        Thread eceDept = new Thread() {
            public void run() {
                admin.displaySortedECEStudents();
            }
        };
        Thread eeeDept = new Thread() {
            public void run() {
                admin.displaySortedEEEStudents();
            }
        };
        cseDept.start();
        eceDept.start();
        eeeDept.start();

    }
}
