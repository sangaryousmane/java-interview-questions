
import oops.ProductionWorker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        List<ProductionWorker> workers = new ArrayList<>();
        ProductionWorker worker = new ProductionWorker();
        worker.setShift(2);
        worker.setEmployeeName("Ousmane");
        worker.setEmployeeNumber("19019198829-MR");
        worker.setHourlyRate(20.75);
        worker.setHireDate(new Date());

        workers.add(worker);
        workers.add(new ProductionWorker("Peter",
                "19019198829-TP", new Date(),
                1, 20.75));
        workers.add(new ProductionWorker("James",
                "19019198829-TT", new Date(),
                1, 20.75));


        AtomicReference<Double> sum = new AtomicReference<>(0.0);
        workers.forEach(person -> {
            double monthlyWage = person.getHourlyRate() * (8 * 30);
            if (person.getShift() != 2) {
                System.out.println(person.getEmployeeName() + " is working day shift");
                System.out.println(person.getEmployeeName() + " monthly wage =  $" + monthlyWage);
            } else {
                System.out.println(person.getEmployeeName() + " is working night shift");
                System.out.println(person.getEmployeeName() + " monthly wage =  $" + monthlyWage);
            }
            sum.set(monthlyWage * 3);
        });
        System.out.println("Total expenditure: " +sum.get());
    }


}
