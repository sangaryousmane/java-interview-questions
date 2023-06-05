import intermediate.ArraysHub;
import intermediate.Searching;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1,2,4,5};
        int target = 3;
        int result = Searching.searchInsertPosition(arr, target);
        System.out.println(result);
    }


}
