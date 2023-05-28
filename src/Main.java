
import intermediate.Searching;

import intro.FourthTasks;
import intro.ThirdTask;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 7, 11};
        int target = 5;
        int result = Searching.kthMissingPositiveNumber(arr, target);
        System.out.println(result);

//       int n = 7;
//        System.out.println(FourthTasks.isPrime(n));

    }


}
