import intermediate.ArraysHub;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {8, 1, 2, 2, 3};
        int target = 3;
        int[] result = ArraysHub.smallerNumberThanCurrent(arr);
        System.out.println(Arrays.toString(result));
    }


}
