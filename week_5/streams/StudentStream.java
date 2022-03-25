package week_5.streams;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int id;
    private String subject;

    double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return name + "-" + id + "-" + subject + "-" + percentage;
    }
}

public class StudentStream {
    public static void main(String[] args) {
        Student student1 = new Student("Dinesh", 1, "Algorithms", 75);
        Student student2 = new Student("Arnav", 2, "Automata", 55);
        Student student3 = new Student("Anamika", 3, "Databases", 80);
        Student student4 = new Student("Vishal", 4, "Networking", 40);
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4));
        // Partition the students who got above 60% from those who didn’t.
        Map<Boolean, List<Student>> l1 = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getPercentage() > 60));
        System.out.println(l1);
        // Get the names of the top 3 performing students.
        List<Student> l2 = students.stream()
                .sorted(Comparator.comparing(Student::getPercentage, Comparator.reverseOrder())).limit(3).toList();
        System.out.println(l2);
        // Get the name and percentage of each student.
        Map<String, Double> m1 = students.stream()
                .collect(Collectors.toMap(Student::getName, Student::getPercentage));
        System.out.println(m1);
        // Get the set of subjects offered in the college
        Set<String> subjects = students.stream().map(Student::getSubject).collect(Collectors.toSet());
        System.out.println(subjects);
        // Get the highest, the lowest, and the average percentage of students
        OptionalDouble highest = students.stream().mapToDouble(Student::getPercentage).max();
        System.out.println("Highest Percentage :" + highest.getAsDouble());
        OptionalDouble lowest = students.stream().mapToDouble(Student::getPercentage).min();
        System.out.println("Lowest Percentage :" + lowest.getAsDouble());
        OptionalDouble average = students.stream().mapToDouble(Student::getPercentage).average();
        System.out.println("Average Percentage :" + average.getAsDouble());
        // Get the total number of students from the given list of students
        System.out.println(students.size());
        // Get the students grouped by subject from the given list of students
        Map<String, List<Student>> map2 = students.stream().collect(Collectors.groupingBy(Student::getSubject));
        System.out.println(map2);

    }

}
