class Student {
    private static int rollInc = 1;
    private int rollNo;
    private String name;
    static final String UNIVERSITYNAME = "SRM";
    private String homeTown;

    Student() {
        rollNo = rollInc;
        this.name = "Karan";
        this.homeTown = "New Delhi";
        rollInc++;
    }

    Student(String name) {
        this();
        this.name = name;
    }

    Student(String name, String homeTown) {
        this(name);
        this.homeTown = homeTown;

    }

    void display() {
        System.out.println(
                "Name - " + getName() + "\nHomw Town - " + homeTown + "\nRoll No - " + getRollNo()
                        + "\nUniversity Name - " + UNIVERSITYNAME);
    }

    String getName() {
        return name;
    }

    int getRollNo() {
        return rollNo;
    }

    void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    void setName(String name) {
        this.name = name;
    }

    void setRollNo(int rollNo) {
        this.rollNo = rollNo;

    }
}

public class StudentInfo {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Shivam");
        student2.setHomeTown("New Delhi");
        Student student3 = new Student("Sagar", "New Delhi");
        String space = "--------------------------------";
        System.out.println("*************** Student Info ***************\n");
        student1.display();
        System.out.println(space);
        student2.display();
        System.out.println(space);
        student3.display();
        System.out.println(space);

    }
}
