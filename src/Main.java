
import intermediate.ArraysHub;
import intermediate.Searching;

import intro.FourthTasks;
import intro.ThirdTask;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {0, 2, 1, 5, 3, 4};
        int target = 5;
        int []result = ArraysHub.permutationBuildArray(arr);
        System.out.println(Arrays.toString(result));

    }


}
