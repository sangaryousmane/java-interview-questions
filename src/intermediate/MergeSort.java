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
        int[] left = new int[middle];
        int[] right = new int[n - middle];

        for (int i=0; i < middle; i++){
            left[i] = nums[i];
        }
        for (int j = middle; j < n; j++){
            right[j - middle] = nums[j];
        }
        mergeSort(left); // sort
        mergeSort(right); // sort

        // merge both halves
        merge(nums, left, right); // Merge
    }

    private static void merge(int[] mix, int[] first, int[] second)
    {
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // At the end, it may be possible that one of the arrays is not complete
        // copy the remaining elements. Please note that either of the loops will run
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
