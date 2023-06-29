package intermediate;

public class Sorting {



    // Perform selection sort
    public static void selectionSort(int[] arr){
        for (int i=0; i < arr.length; i++){

            int lastIndex=arr.length - i -1;
            int start = 0;

            int maxIndex = start;
            for (int j = start; j <= lastIndex; j++){
                if (arr[maxIndex] < arr[j])
                    maxIndex = j;
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[lastIndex];
            arr[lastIndex] = temp;
        }
    }

    private static int getMaxIndex(int[] arr, int start, int lastIndex) {
        int max = start;

        for (int i = start; i <= lastIndex; i++) {
            if (arr[max] < arr[i])
                max = i;
        }
        return max;
    }

    public static void bubbleSort(int[] arr) {

        // Initialize whether the array is swapped
        boolean isSwapped;

        // run the steps until the end of the array (n-1)
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false; // swapping hasn't occurred yet

            // For each step, the max item will come at the last respective index
            for (int j = 1; j < arr.length - i; j++) {
//
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
