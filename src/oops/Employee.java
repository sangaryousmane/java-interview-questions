package oops;

import java.util.Date;

public class Employee {
    private String employeeName;
    private String employeeNumber;

    private Date hireDate;


    public Employee(String name, String employeeNumber, Date hireDate){
        this.employeeName=name;
        this.employeeNumber=employeeNumber;
        this.hireDate=hireDate;
    }

    public Employee() {

    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}

