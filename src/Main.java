
import intermediate.Searching;

import intro.FourthTasks;
import intro.ThirdTask;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int []numbers = {-11, -5 , 1, 2, 5, 8};
        int target = 2;
        int result = Searching.orderAgnosticBinarySearch(numbers, target);
        System.out.println(result);

       int n = 7;
        System.out.println(FourthTasks.isPrime(n));

    }


}
