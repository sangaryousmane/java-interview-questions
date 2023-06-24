import oops.CargoShip;
import oops.ProductionWorker;
import oops.ShiftSupervisor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        demonstrateShip();
//        System.out.println(WorkingWithStrings
//                .wordCount("Hello there, how r"));
    }


    private static void demonstrateShip() {
//        Ship cruise = new CargoShip(
//                "Titanic", "2022",
//                300);
//        System.out.println(cruise);

        CargoShip cargoShip = new CargoShip(
                "Tetris",
                "2025", 4000);
        System.out.println(cargoShip);
    }

    private static void demonstrateCustomer() {
        ShiftSupervisor s = new ShiftSupervisor();
        s.setGoalMet(true);
        s.setEmployeeName("Ousmane");
        s.setEmployeeNumber("19019198829-MR");
        s.setAnnualSalary(8000.0);
        s.setHireDate(new Date());

        if (s.isGoalMet()) {
            s.setBonus(100.0);
        } else {
            s.setBonus(0.0);
        }
        s.setAnnualSalary(s.getAnnualSalary() + (s.getBonus() * 12));
        System.out.println(s);

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
        System.out.println("Total expenditure: " + sum.get());
    }

}
