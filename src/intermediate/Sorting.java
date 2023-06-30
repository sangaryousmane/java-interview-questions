package intermediate;

public class Sorting {



    // Only number in the range that is missing from the array
    // https://leetcode.com/problems/missing-number/description/
    public static int missingNumber(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correctIndex = arr[i]; // index of current element

            // Swap the elements of the array
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]){
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else{
                i++;
            }
        }

        // Check for the missing number in the array
        // case 1
        for (int index = 0; index < arr.length; index++){
            if (arr[index] !=index){
                return index;  // if the element is not equal to it current index, then the index is the missing
            }
        }

        // return the length of the element if the missing element is the
        // ith element that is not in the array. eg: [0, 1, 2, 3]. missing element is 4
        return arr.length;
    }
    // Perform cyclic sort
    public static void cyclicSort(int[] arr) {
        // Iterate over the array once
        // check if the current element is equal
        // to the value of the element's index minus one
        // swap if not, else go to the next element
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
    }

    // Perform insertion sort. It is stable
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    // arr[j] = current element
                    // arr[j-1] = previous element
                } else
                    break;
            }
        }
    }

    // Perform selection sort
    public static void selectionSort(int[] arr) {

        // Find index of last element
        // Find maximum number
        // swap maximum number with last index

        for (int i = 0; i < arr.length; i++) {

            int lastIndex = arr.length - i - 1;
            int start = 0;
            int maxIndex = start;

            for (int j = start; j <= lastIndex; j++) {
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
