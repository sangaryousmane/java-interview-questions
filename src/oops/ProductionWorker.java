package oops;

import java.util.Date;

public class ProductionWorker extends Employee {

    private int shift;
    private double hourlyRate;

    public ProductionWorker() {

    }

    public ProductionWorker(String name, String employeeNumber, Date hireDate) {
        super(name, employeeNumber, hireDate);
    }

    public ProductionWorker(String name,
                            String employeeNumber, Date hireDate, int shift, double hourlyRate) {
        super(name, employeeNumber, hireDate);
        this.shift = shift;
        this.hourlyRate = hourlyRate;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
