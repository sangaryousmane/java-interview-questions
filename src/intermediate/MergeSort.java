package intermediate;

import java.util.Arrays;
import java.util.Random;

import static intermediate.Quicksort.printArray;

public class MergeSort {
    public static void main(String[] args) {
        Random random=new Random();
        int[] nums=new int[100];
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(100);
        }
        printArray(nums);
        mergeSort(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("After: ");
        printArray(nums);
        System.out.println("\nTime taken: " + (endTime - startTime) + "ms");

    }


    static void mergeSort(int[] nums) {

        if (nums == null || nums.length < 2)
            return;

        int n = nums.length;
        int middle = n / 2;
        int[] leftSubArray = new int[middle];
        int[] rightSubArray = new int[n - middle];

        for (int i=0; i < middle; i++){
            leftSubArray[i] = nums[i];
        }
        for (int j = middle; j < n; j++){
            // start the right sub array from 0. eg: if middle is 5, j is also 5
            // Therefore, 5 - 5 = 0. when j is 6, we get 6 - 5 = 1, when j is 7
            // we get 7 - 5 = 2 and so on
            rightSubArray[j - middle] = nums[j];
        }
        mergeSort(leftSubArray); // sort leftSubArray sub array
        mergeSort(rightSubArray); // sort rightSubArray sub array

        // merge both halves
        merge(nums, leftSubArray, rightSubArray); // Merge both leftSubArray and rightSubArray sub array
    }

    private static void merge(int[] mix, int[] first, int[] second)
    {
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // At the end, it may be possible that one of the arrays is not complete
        // copy the remaining elements. Please note that either of the loops will run not both
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
    }
}
