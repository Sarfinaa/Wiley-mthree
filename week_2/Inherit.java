package week_2;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Employee extends Person {
    double annualSalary;
    int year;

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, String name2, double annualSalary, int year) {
        super(name);
        name = name2;
        this.annualSalary = annualSalary;
        this.year = year;
    }

    public Employee(String name, String name2, String uAN) {
        super(name);
        name = name2;
        UAN = uAN;
    }

    String UAN;

    Employee(String name, int annualSalary, int year, String UAN) {
        super(name);
        this.annualSalary = annualSalary;
        this.year = year;
        this.UAN = UAN;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUAN() {
        return UAN;
    }

    public void setUAN(String uAN) {
        UAN = uAN;
    }

    public String toString() {
        return "Employee Name: " + name + " Annual Salary: " + annualSalary + " Joining Year: " + year + " UAN: " + UAN;
    }

    public boolean isEqualTo(Employee other) {
        if (!name.equals(other.name))
            return false;
        if (year != other.year)
            return false;
        if (annualSalary != other.annualSalary)
            return false;
        if (!UAN.equals(other.UAN))
            return false;
        return true;
    }

}

public class Inherit {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Karan Seth", 1000000, 2022, "#7942");
        // Employee emp2 = new Employee("Shivam Khanna", 1000000, 2022, "#7943");
        Employee emp3 = new Employee("Karan Seth", 1000000, 2022, "#7942");
        Person person1 = new Person("Karan Seth");
        Employee emp4 = new Employee("Karan Seth");
        System.out.println(emp1);
        System.out.println(emp4.equals(person1));
        System.out.println(emp1.isEqualTo(emp3));

    }
}