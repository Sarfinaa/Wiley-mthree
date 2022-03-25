package week_4.collections;

import java.util.ArrayList;
import java.util.List;

class Employee implements Comparable<Employee> {
    protected long employeeId;
    protected String firstName;
    protected String lastName;

    Employee(long employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int compareTo(Employee other) {
        // if (this.employeeId < other.employeeId)
        // return -1;
        // else if (this.employeeId > other.employeeId)
        // return 1;
        // else
        // return 0;
        return (int) (this.employeeId - other.employeeId);
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    public boolean isEqual(Employee other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (!(other instanceof Employee))
            return false;
        return this.employeeId == other.employeeId;
    }

    public static void swap(int i, int j, List<Employee> employees) {
        Employee tmp = employees.get(i);
        employees.set(i, employees.get(j));
        employees.set(j, tmp);
    }

    // Bubble Sort
    public static void bubbleSort(List<Employee> employees) {
        int n = employees.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (employees.get(j).compareTo(employees.get(j + 1)) > 0) {
                    swap(i, j, employees);
                }
            }
        }
    }
    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Employee other = (Employee) obj;
    // if (employeeId != other.employeeId)
    // return false;
    // return true;
    // }

}

public class EmpoyeeData {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(2, "Karan", "Seth"));
        employees.add(new Employee(1, "Shivam", "Khanna"));
        employees.add(new Employee(3, "Sagar", "Chaurasia"));
        // employees.add(new Employee(1, "Karan", "Seth"));
        // System.out.println(employees.get(0).isEqual(employees.get(3)));
        // System.out.println(employees.get(0).compareTo(employees.get(1)));
        // System.out.println(employees.get(1).compareTo(employees.get(0)));
        Employee.bubbleSort(employees);
        employees.forEach(System.out::println);

    }
}
