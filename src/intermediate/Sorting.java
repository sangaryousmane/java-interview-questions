package intermediate;

import java.util.Arrays;

public class Sorting {

    public static void bubbleSort(int[] arr) {

        // Initialize whether the array is swapped
        boolean isSwapped;

        // run the steps until the end of the array (n-1)
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false; // swapping hasn't occurred yet

            // For each step, the max item will come at the last respective index
            for (int j = 1; j < arr.length - i; j++) {

                // check if the current item is smaller than the previous item
                if (arr[j] < arr[j - 1]) {

                    // Swap if the current item is smaller than the previous item
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwapped = true; // After initial swap
                }
            }

            // Break the loop and return the elements in the array if it's already sorted
            // Array is already sorted when there is no swapping done.
            if (!isSwapped) {
                break;
            }
        }
    }
}
