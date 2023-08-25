import advance.linkedlist.CircularLinkedList;
import advance.linkedlist.DLL;
import advance.linkedlist.SLL;
import intermediate.ArraysHub;
import oops.ProductionWorker;
import oops.ShiftSupervisor;
import recursive.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll=new CircularLinkedList();
        cll.add(10);
        cll.display();
    }

    private static void doublyLinked() {
        DLL dll=new DLL();
        dll.add(10);
        dll.add(100);
        dll.add(90);
        dll.addEnd(210);
        dll.addAtIndex(100, 1);
        dll.display();
        dll.displayRev();
    }

    private static void singlyLinkedList() {
        SLL sll=new SLL();
        sll.add(4);
        sll.add(10);
        sll.addEnd(20);
        sll.addEnd(30);

        // insert at an index
        sll.addAtIndex(100, 2);
        sll.addAtIndex(201, 1);
        sll.displayListContent();

//        System.out.println("Deleted: " + sll.deleteLast()); // Delete the first element
        sll.deleteByIndex(3);
        sll.displayListContent();
    }

    static List<Integer> disapear(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correctIndex = arr[i] - 1;

            if (arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
        List<Integer> notFound = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1)
                notFound.add(index + 1);
        }
        return notFound;
    }

    static void selection(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void checkMatrix() {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49}};
        int[] result = ArraysHub.searchInMatrix(arr, 49);
        System.out.println(Arrays.toString(result));
    }


    private static void demonstrateShip() {
//        Ship cruise = new CargoShip(
//                "Titanic", "2022",
//                300);
//        System.out.println(cruise);

        int[] min = {3, 4, 5, 1, 0};
        System.out.println(Recursion.recursiveMultiplication(5, 4));
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
