
package week_5;

import java.util.*;

class Department {
    private String departmentName;
    private Staff staff;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Staff getStaff() {
        return staff;
    }

    public Department(String departmentName, Staff staff) {
        this.departmentName = departmentName;
        this.staff = staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void displayStaff() {
        System.out.println(String.format("%s is working in the %s department as %s", staff.getStaffName(),
                departmentName, staff.getDesignation()));
    }

}

class Staff {
    private String staffName;
    private String designation;

    public Staff(String staffName, String designation) {
        this.staffName = staffName;
        this.designation = designation;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String desig = s.nextLine();
        String depart = s.nextLine();
        new Department(depart, new Staff(name, desig)).displayStaff();
    }
}