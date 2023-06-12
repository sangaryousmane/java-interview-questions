import intermediate.ArraysHub;
import intermediate.Searching;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int result = Searching.elementOfInfiniteArray(arr, 10);
        System.out.println(result);
    }


}
