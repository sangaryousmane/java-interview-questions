import advance.linkedlist.CircularLinkedList;
import advance.linkedlist.DLL;
import advance.linkedlist.SLL;
import intermediate.ArraysHub;
import intermediate.Quicksort;
import intermediate.Sorting;
import oops.ProductionWorker;
import oops.ShiftSupervisor;
import recursive.Recursion;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import static intermediate.Sorting.swap;


public class Main {

    private static Logger logger=Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        logger.log(Level.INFO, "I am fine");
    }

    public static void mergeSort(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 2)
            return;

        int midPoint = n / 2; // Divide the array into half
        int[] leftHalf = new int[midPoint];
        int[] rightHalf = new int[n - midPoint];

        // Copy all elements from start to the midpoint
        for (int i = 0; i < midPoint; i++) {
            leftHalf[i] = nums[i];
        }
        // Copy all elements from the midpoint to the length
        for (int i = midPoint; i < n; i++) {
            rightHalf[i - midPoint] = nums[i];
        }

        mergeSort(leftHalf); // sort left half
        mergeSort(rightHalf); // sort right half
        merge(nums, leftHalf, rightHalf); // merge the left and right half
    }

    private static void merge(int[] merged, int[] first, int[] second) {

        // Get three variables, i for the first, j for the second, k for the merged array
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }

        // Check for remaining elements in the left or right but not both
        while (i < first.length){
            merged[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length){
            merged[k] = second[j];
            j++;
            k++;
        }
    }

    static void bubble_sort(int[] array, int size) {
        int i, j;

    }

    private static void queue() {
        Queue<String> names = new LinkedList<>();
        names.add("Laye");
        names.add("Kadiatu");
        names.add("Aisha");
        System.out.println(names);
        System.out.println(names.peek());
        System.out.println(names);
        names.remove("Aisha");
        System.out.println(names);
    }

    private static void stack_impl() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    public static int squareOfDigits(int n) {
        int ans = 0;
        while (n > 0) {
            int remainder = n % 10;
            ans += remainder * remainder;
            n /= 10;
        }
        return ans;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += remainder * remainder;
            n /= 10;
        }
        return sum;
    }

    private static void circular() {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(10);
        cll.display();
    }

    private static void doublyLinked() {
        DLL dll = new DLL();
        dll.add(10);
        dll.add(100);
        dll.add(90);
        dll.addEnd(210);
        dll.addAtIndex(100, 1);
        dll.display();
        dll.displayRev();
    }

    private static void singlyLinkedList() {
        SLL sll = new SLL();
        sll.add(4);
        sll.add(10);
        sll.addEnd(20);
        sll.addEnd(30);

        // insert at an index
        sll.addAtIndex(100, 2);
        sll.addAtIndex(201, 1);
        sll.displayListContent();

//        System.out.txt.println("Deleted: " + sll.deleteLast()); // Delete the first element
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
//        System.out.txt.println(cruise);

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
