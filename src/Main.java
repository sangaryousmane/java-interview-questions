import intermediate.ArraysHub;
import intermediate.Searching;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1};
        int[]aliceSizes = {2}, bobSizes = {1,3};
        int[] result = Searching.fairCandySwap(aliceSizes, bobSizes);
        System.out.println(Arrays.toString(result));
    }


}
